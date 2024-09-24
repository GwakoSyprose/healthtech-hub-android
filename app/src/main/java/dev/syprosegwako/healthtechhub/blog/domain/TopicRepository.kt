package dev.syprosegwako.healthtechhub.blog.domain

interface TopicRepository {
    suspend fun getTopics(): List<TopicItem>
    suspend fun getTopicsFromLocalCache(): List<TopicItem>
    suspend fun getTopicsFromRemote()
}