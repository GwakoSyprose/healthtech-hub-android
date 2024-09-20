package dev.syprosegwako.healthtechhub.blog.presentation.blog_list

import dev.syprosegwako.healthtechhub.blog.domain.BlogItem

data class BlogListState(
    val blogs: List<BlogItem> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)
