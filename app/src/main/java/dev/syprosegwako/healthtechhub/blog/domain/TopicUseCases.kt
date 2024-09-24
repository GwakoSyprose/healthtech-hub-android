package dev.syprosegwako.healthtechhub.blog.domain

import android.util.Log
import javax.inject.Inject

class TopicUseCases @Inject constructor(
    private val topicRepository: TopicRepository
) {

    suspend fun getTopics(): TopicUseCaseResult {
        try {
            var topics = topicRepository.getTopicsFromLocalCache()
            Log.e("useCaseLocalTopic", topics.toString())

            if (topics.isEmpty()) {
                topics = topicRepository.getTopics()
                Log.e("useCaseRemoteTopic", topics.toString())
            }
            return TopicUseCaseResult.Success(topics)
        } catch (e: Exception) {
            return TopicUseCaseResult.Error("Could not load topics")
        }
    }
}

sealed class TopicUseCaseResult {
    data class Success(val topics: List<TopicItem>) : TopicUseCaseResult()
    data class Error(val message: String) : TopicUseCaseResult()
}