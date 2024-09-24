package dev.syprosegwako.healthtechhub.blog.presentation.blog_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.syprosegwako.healthtechhub.blog.domain.BlogUseCases
import dev.syprosegwako.healthtechhub.blog.presentation.blog_add.BlogState
import dev.syprosegwako.healthtechhub.util.Constants.Navigation.ARG_BLOG_ID
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogDetailViewModel @Inject constructor(
    private val blogUseCases: BlogUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(BlogState())
    val state: State<BlogState> = _state

    init {
        savedStateHandle.get<Int>(ARG_BLOG_ID)?.let { id ->
            if(id != -1){
                viewModelScope.launch(){
                    blogUseCases.getBlogById(id)?.also { blog ->
                        _state.value = _state.value.copy(
                            blog = blog,
                            isLoading = false
                        )
                    }
                }
            }else{
                _state.value = _state.value.copy(
                    isLoading = false
                )
            }

        }
    }


}