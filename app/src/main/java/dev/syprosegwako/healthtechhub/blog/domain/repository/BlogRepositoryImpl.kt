package dev.syprosegwako.healthtechhub.blog.domain.repository

import android.util.Log
import dev.syprosegwako.healthtechhub.blog.domain.BlogItem
import dev.syprosegwako.healthtechhub.di.IoDispatcher
import dev.syprosegwako.healthtechhub.data.local.BlogDao
import dev.syprosegwako.healthtechhub.data.mapper.toBlogItem
import dev.syprosegwako.healthtechhub.data.mapper.toBlogItemListFromLocal
import dev.syprosegwako.healthtechhub.data.mapper.toLocalBlogItem
import dev.syprosegwako.healthtechhub.data.mapper.toLocalBlogItemListFromRemote
import dev.syprosegwako.healthtechhub.data.mapper.toRemoteBlogItem
import dev.syprosegwako.healthtechhub.data.remote.BlogApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

class BlogRepositoryImpl(
    private val blogDao: BlogDao,
    private val api: BlogApi,
    @IoDispatcher val dispatcher: CoroutineDispatcher
) : BlogRepository {
    override suspend fun getBlogs(): List<BlogItem> {
        getBlogsFromRemote()
        return blogDao.getBlogs().toBlogItemListFromLocal()
    }

    override suspend fun getBlogsFromLocalCache(): List<BlogItem> {
        return blogDao.getBlogs().toBlogItemListFromLocal()
    }

    override suspend fun getBlogsFromRemote() {
        return withContext(dispatcher) {
            try {
                refreshRoomCache()
            } catch (e: Exception) {
                Log.e("getBlogsFromRemoteException", e.message.toString())
                when (e) {
                    is UnknownHostException, is ConnectException, is HttpException -> {
                        Log.e("HTTP", "Error loading blogs")
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
        val remoteBlogs = api.getBlogs()
        blogDao.addBlogs(remoteBlogs.toLocalBlogItemListFromRemote())
    }

    private suspend fun isCacheEmpty(): Boolean {
        var empty = true
        if (blogDao.getBlogs().isNotEmpty()) empty = false
        return empty
    }

    override suspend fun getBlogById(id: Int): BlogItem? {
        return blogDao.getBlogById(id)?.toBlogItem()
    }

    override suspend fun addBlog(blog: BlogItem) {
        val newId = blogDao.addBlog(blog.toLocalBlogItem())
        val id = newId.toInt()
        Log.e("addingToRemote", (blog.toRemoteBlogItem().copy(id = id).toString()))
        api.addBlog(blog.toRemoteBlogItem().copy(id = id))
    }

}