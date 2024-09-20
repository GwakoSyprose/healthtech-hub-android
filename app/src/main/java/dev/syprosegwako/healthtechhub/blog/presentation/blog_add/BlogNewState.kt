package dev.syprosegwako.healthtechhub.blog.presentation.blog_add

import dev.syprosegwako.healthtechhub.blog.domain.BlogItem

data class BlogNewState (
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
    val error: String? = null,
    val currentBlogId: Int? = null
)
