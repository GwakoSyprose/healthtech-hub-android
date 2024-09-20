package dev.syprosegwako.healthtechhub.blog.presentation.blog_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.syprosegwako.healthtechhub.blog.domain.BlogUseCaseResult
import dev.syprosegwako.healthtechhub.blog.domain.BlogUseCases
import dev.syprosegwako.healthtechhub.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogListViewModel @Inject constructor(
    private val blogUseCases: BlogUseCases,
    @IoDispatcher val dispatcher: CoroutineDispatcher
): ViewModel() {

    private val _state = mutableStateOf(BlogListState())
    val state: State<BlogListState> = _state

    private var getBlogsJob: Job? = null
    private val errorHandler = CoroutineExceptionHandler {_, e ->
        e.printStackTrace()
        _state.value = _state.value.copy(
            error = e.message,
            isLoading = false
        )
    }


    fun getBlogs() {
        getBlogsJob?.cancel()

        getBlogsJob = viewModelScope.launch(dispatcher + errorHandler) {
            val result = blogUseCases.getBlogs()
            when(result){
                is BlogUseCaseResult.Success -> {
                    _state.value = state.value.copy(
                        blogs = result.blogs,
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

    fun onFilterTopics(id: Int){
        Log.e("blogviewmodel", "clicked")
//        viewModelScope.launch(dispatcher + errorHandler) {
//
//        }
    }


}