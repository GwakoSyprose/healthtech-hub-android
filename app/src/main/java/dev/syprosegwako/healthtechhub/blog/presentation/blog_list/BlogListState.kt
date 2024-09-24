package dev.syprosegwako.healthtechhub.blog.presentation.blog_list

import dev.syprosegwako.healthtechhub.blog.domain.BlogItem
import dev.syprosegwako.healthtechhub.blog.domain.TopicItem

data class BlogListState(
    val blogs: List<BlogItem> = emptyList(),
    var topics: List<TopicItem> = emptyList(),
    val selectedTopicIds: List<Int> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)
