package dev.syprosegwako.healthtechhub.blog.domain.repository

import android.util.Log
import dev.syprosegwako.healthtechhub.blog.domain.TopicItem
import dev.syprosegwako.healthtechhub.data.local.TopicDao
import dev.syprosegwako.healthtechhub.data.mapper.toLocalTopicItemListFromRemote
import dev.syprosegwako.healthtechhub.data.mapper.toTopicItemListFromLocal
import dev.syprosegwako.healthtechhub.data.remote.BlogApi
import dev.syprosegwako.healthtechhub.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

class TopicRepositoryImpl(
    private val dao: TopicDao,
    private val api: BlogApi,
    @IoDispatcher val dispatcher: CoroutineDispatcher
): TopicRepository {
    override suspend fun getTopics(): List<TopicItem> {
        getTopicsFromRemote()
        return dao.getTopics().toTopicItemListFromLocal()
    }

    override suspend fun getTopicsFromLocalCache(): List<TopicItem> {
        return dao.getTopics().toTopicItemListFromLocal()
    }

    override suspend fun getTopicsFromRemote() {
        return withContext(dispatcher) {
            try {
                refreshRoomCache()
            } catch (e: Exception) {
                Log.e("getTopicsFromRemoteException", e.message.toString())
                when (e) {
                    is UnknownHostException, is ConnectException, is HttpException -> {
                        Log.e("HTTP", "Error loading topics")
                        if (isCacheEmpty()) {
                            Log.e("Cache", "Error: No data from local room cache")
                            throw Exception("Error: Device offline and no data from cache")
                        }
                    }
                    else -> throw e
                }
            }
        }
    }

    private suspend fun refreshRoomCache() {
        val remoteTopics = api.getTopics().distinctBy { it.title }
        Log.e("remoteTopics", remoteTopics.toString())
        dao.addTopics(remoteTopics.toLocalTopicItemListFromRemote())
    }

    private suspend fun isCacheEmpty(): Boolean {
        var empty = true
        if (dao.getTopics().isNotEmpty()) empty = false
        return empty
    }

}