package dev.syprosegwako.healthtechhub.blog.presentation.blog_add

import dev.syprosegwako.healthtechhub.blog.domain.BlogItem

data class BlogState (
    val blog: BlogItem = BlogItem(
        id = null,
        name = "",
        surname = "",
        topicId = 0,
        body = "",
        subject = "",
        createdAt = "",
        updatedAt = ""
    ),
    val isLoading: Boolean = true,
    val error: String? = null
)
