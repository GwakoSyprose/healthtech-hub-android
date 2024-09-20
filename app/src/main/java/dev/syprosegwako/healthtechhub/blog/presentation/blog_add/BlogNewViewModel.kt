package dev.syprosegwako.healthtechhub.blog.presentation.blog_add

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.syprosegwako.healthtechhub.blog.domain.BlogUseCases
import dev.syprosegwako.healthtechhub.blog.presentation.blog_list.BlogListState
import dev.syprosegwako.healthtechhub.di.IoDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

//@HiltViewModel
//class BlogNewViewModel @Inject constructor(
//    private val blogUseCases: BlogUseCases,
//    savedStateBundle: SavedStateHandle,
//    @IoDispatcher private val dispatcher: IoDispatcher
//): ViewModel() {
//
//    private val _state = mutableStateOf(BlogNewState())
//    val state: State<BlogNewState> = _state
//
//    private val errorHandler = CoroutineExceptionHandler {_, e ->
//        e.printStackTrace()
//        _state.value = _state.value.copy(
//            error = e.message,
//            isLoading = false
//        )
//    }
//
//}