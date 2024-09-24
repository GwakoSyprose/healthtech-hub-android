package dev.syprosegwako.healthtechhub.blog.presentation.blog_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.syprosegwako.healthtechhub.blog.domain.BlogItem
import dev.syprosegwako.healthtechhub.blog.domain.BlogUseCaseResult
import dev.syprosegwako.healthtechhub.blog.domain.BlogUseCases
import dev.syprosegwako.healthtechhub.blog.domain.TopicItem
import dev.syprosegwako.healthtechhub.blog.domain.TopicUseCaseResult
import dev.syprosegwako.healthtechhub.blog.domain.TopicUseCases
import dev.syprosegwako.healthtechhub.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogListViewModel @Inject constructor(
    private val blogUseCases: BlogUseCases,
    private val topicUseCases: TopicUseCases,
    @IoDispatcher val dispatcher: CoroutineDispatcher
): ViewModel() {

    companion object {
        const val TOPIC_ALL = "All"
        const val TOPIC_ALL_ID = -1
    }

    private val _state = mutableStateOf(BlogListState())
    val state: State<BlogListState> = _state

    private var getBlogsJob: Job? = null
    private var getTopicsJob: Job? = null
    private val errorHandler = CoroutineExceptionHandler {_, e ->
        e.printStackTrace()
        _state.value = _state.value.copy(
            error = e.message,
            isLoading = false
        )
    }

    //the original unfiltered list
    private var originalBlogList: List<BlogItem> = emptyList()

    init {
            getTopics()
    }

    private fun getTopics() {
        getTopicsJob?.cancel()

        getTopicsJob = viewModelScope.launch(dispatcher + errorHandler) {
            when (val result = topicUseCases.getTopics()){
                is TopicUseCaseResult.Success -> {
                    // TopicItem for the "All" topic
                    val allTopicItem = TopicItem(
                        id = TOPIC_ALL_ID,
                        title = TOPIC_ALL
                    )
                    val topicsWithAll = listOf(allTopicItem) + result.topics

                    _state.value = _state.value.copy(
                        topics = topicsWithAll,
                        selectedTopicIds = listOf(TOPIC_ALL_ID),
                        isLoading = false
                    )
                }
                is TopicUseCaseResult.Error -> {
                    _state.value = state.value.copy(
                        error = "Error: Cannot load topics",
                        isLoading = false
                    )
                }
            }
        }

    }

    fun getBlogs() {
        getBlogsJob?.cancel()

        getBlogsJob = viewModelScope.launch(dispatcher + errorHandler) {
            when(val result = blogUseCases.getBlogs()){
                is BlogUseCaseResult.Success -> {
                    originalBlogList = result.blogs
                    _state.value = _state.value.copy(
                        blogs = getFilteredBlogs(_state.value.selectedTopicIds),
                        isLoading = false
                    )
                }
                is BlogUseCaseResult.Error -> {
                    _state.value = state.value.copy(
                        error = "Error: Cannot load blog posts",
                        isLoading = false
                    )
                }
            }
        }

    }

    /**
     * Handles the selection of a topic filter and updates the selected topic IDs.
     * If the "All" filter is selected, all other filters are cleared.
     * If no topic filters are selected, the "All" filter is added by default.
     *
     * @param topicId The ID of the selected topic filter. If it matches the `TOPIC_ALL_ID`,
     *                all other filters are cleared and "All" is selected.
     */
    fun onTopicSelected(topicId: Int) {
        val updatedSelectedTopicIds = _state.value.selectedTopicIds.toMutableList()

        if (topicId == TOPIC_ALL_ID) {
            updatedSelectedTopicIds.clear()
            updatedSelectedTopicIds.add(TOPIC_ALL_ID)
        } else {
            updatedSelectedTopicIds.remove(TOPIC_ALL_ID)

            if (updatedSelectedTopicIds.contains(topicId)) {
                updatedSelectedTopicIds.remove(topicId)
            } else {
                updatedSelectedTopicIds.add(topicId)
            }
            if (updatedSelectedTopicIds.isEmpty()) {
                updatedSelectedTopicIds.add(TOPIC_ALL_ID)
            }
        }

        // Update state with new selected topics and filtered blogs
        _state.value = _state.value.copy(
            selectedTopicIds = updatedSelectedTopicIds,
            blogs = getFilteredBlogs(updatedSelectedTopicIds)
        )
    }


    /**
     * Filters the list of blogs based on the selected topic IDs.
     * If the "All" filter is selected or the list of selected topic IDs is empty,
     * all blogs are returned. Otherwise, only blogs that match the selected topic IDs are returned.
     *
     * @param selectedTopicIds A list of selected topic IDs used to filter the blogs.
     *                         If the list is empty or contains `TOPIC_ALL_ID`,
     *                         all blogs are returned.
     * @return A list of filtered `BlogItem` objects that match the selected topic IDs.
     */
    private fun getFilteredBlogs(selectedTopicIds: List<Int>): List<BlogItem> {
        return if (selectedTopicIds.contains(TOPIC_ALL_ID) || selectedTopicIds.isEmpty()) {
            originalBlogList
        } else {
            originalBlogList.filter { blog ->
                selectedTopicIds.contains(blog.topicId)
            }
        }
    }

}