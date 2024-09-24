package dev.syprosegwako.healthtechhub.blog.domain

import javax.inject.Inject

class BlogUseCases @Inject constructor(
    private val blogRepository: BlogRepository
) {
    suspend fun addBlog(blog: BlogItem) {
        if (blog.name.isBlank() ||
            blog.surname.isBlank() ||
            blog.subject.isBlank() ||
            blog.body.isBlank() ||
            blog.topicId.toString().isBlank()
        ) {
            throw IllegalArgumentException("All fields must be filled")
        }
        blogRepository.addBlog(blog)

    }

    suspend fun getBlogs(): BlogUseCaseResult {
        try {
            var blogs = blogRepository.getBlogsFromLocalCache()

            if (blogs.isEmpty()) {
                blogs = blogRepository.getBlogs()
            }
            return BlogUseCaseResult.Success(blogs)
        } catch (e: Exception) {
            return BlogUseCaseResult.Error("Could not load blogs")
        }
    }

    suspend fun getBlogById(id: Int): BlogItem? {
        return blogRepository.getBlogById(id)
    }
}

sealed class BlogUseCaseResult {
    data class Success(val blogs: List<BlogItem>) : BlogUseCaseResult()
    data class Error(val message: String) : BlogUseCaseResult()
}