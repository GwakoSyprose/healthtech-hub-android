package dev.syprosegwako.healthtechhub.blog.domain

data class BlogItem(
    val id: Int?,
    val name: String,
    val surname: String,
    val subject: String,
    val body: String,
    val topicId: Int,
    val createdAt: String,
    val updatedAt: String
)
