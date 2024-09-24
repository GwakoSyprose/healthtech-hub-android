package dev.syprosegwako.healthtechhub.blog.presentation.blog_add

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.syprosegwako.healthtechhub.blog.domain.BlogUseCases
import dev.syprosegwako.healthtechhub.blog.domain.TopicItem
import dev.syprosegwako.healthtechhub.di.IoDispatcher
import dev.syprosegwako.healthtechhub.util.getCurrentTimestamp
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogNewViewModel @Inject constructor(
    private val blogUseCases: BlogUseCases,
    @IoDispatcher val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state = mutableStateOf(BlogState())
    val state: State<BlogState> = _state


    var nameError by mutableStateOf(false)
        private set
    var surnameError by mutableStateOf(false)
        private set

    var subjectError by mutableStateOf(false)
        private set

    var bodyError by mutableStateOf(false)
        private set

    var topicError by mutableStateOf(false)
        private set


    fun onNameChanged(newName: String) {
        _state.value = _state.value.copy(
            blog = _state.value.blog.copy(name = newName)
        )
        nameError = newName.isBlank()
    }

    fun onSurnameChanged(newSurname: String) {
        _state.value = _state.value.copy(
            blog = _state.value.blog.copy(surname = newSurname)
        )
        surnameError = newSurname.isBlank()
    }

    fun onSubjectChanged(newSubject: String) {
        _state.value = _state.value.copy(
            blog = _state.value.blog.copy(subject = newSubject)
        )
        subjectError = newSubject.isBlank()
    }

    fun onBodyChanged(newBody: String) {
        _state.value = _state.value.copy(
            blog = _state.value.blog.copy(body = newBody)
        )
        bodyError = newBody.isBlank()
    }

    fun onTopicSelected(newTopicId: Int) {
        _state.value = _state.value.copy(
            blog = _state.value.blog.copy(topicId = newTopicId)
        )
        topicError = newTopicId == 0
    }

    fun isFormValid(): Boolean {
        validateForm()
        return !(nameError || surnameError || subjectError || bodyError || topicError)
    }

    private fun validateForm() {
        _state.value.blog.apply {
            nameError = name.isBlank()
            surnameError = surname.isBlank()
            subjectError = subject.isBlank()
            bodyError = body.isBlank()
            topicError = (topicId == 0)
        }
    }

    fun saveBlog() {
        viewModelScope.launch(dispatcher + errorHandler) {
            try {
                blogUseCases.addBlog(
                    _state.value.blog.copy(
                        createdAt = getCurrentTimestamp(),
                        id = null
                    )
                )

            } catch (e: Exception) {
                Log.e("Add blog error", "Add blog error")
            }
        }

    }

  val topics = listOf(
    TopicItem(id = 1, title = "Trends"),
    TopicItem(id = 2, title = "Industry News"),
    TopicItem(id = 3, title = "Health")
    )

    private val errorHandler = CoroutineExceptionHandler { _, e ->
        e.printStackTrace()
        _state.value = _state.value.copy(
            error = e.message,
            isLoading = false
        )
    }


}