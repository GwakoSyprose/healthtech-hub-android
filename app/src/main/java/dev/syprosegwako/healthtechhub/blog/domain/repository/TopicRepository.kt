package dev.syprosegwako.healthtechhub.blog.domain.repository

import dev.syprosegwako.healthtechhub.blog.domain.TopicItem

interface TopicRepository {
    suspend fun getTopics(): List<TopicItem>
    suspend fun getTopicsFromLocalCache(): List<TopicItem>
    suspend fun getTopicsFromRemote()
}