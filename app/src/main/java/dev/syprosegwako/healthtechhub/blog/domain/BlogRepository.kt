package dev.syprosegwako.healthtechhub.blog.domain

interface BlogRepository {
    suspend fun getBlogs(): List<BlogItem>
    suspend fun getBlogsFromLocalCache(): List<BlogItem>
    suspend fun getBlogsFromRemote()
    suspend fun getBlogById(id: Int): BlogItem?
    suspend fun addBlog(blog: BlogItem)
}