package dev.syprosegwako.healthtechhub.blog.presentation.blog_add

sealed class BlogNewEvent {
    data object AddBlog: BlogNewEvent()
    data object GoBack: BlogNewEvent()
}