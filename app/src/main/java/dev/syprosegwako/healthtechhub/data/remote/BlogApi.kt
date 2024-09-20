package dev.syprosegwako.healthtechhub.data.remote


import dev.syprosegwako.healthtechhub.data.remote.dto.RemoteBlogItem
import dev.syprosegwako.healthtechhub.data.remote.dto.RemoteTopicItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BlogApi {
    @GET("blog/get")
    suspend fun getBlogs(): List<RemoteBlogItem>

    @GET("topic/get")
    suspend fun getTopics(): List<RemoteTopicItem>

    @POST("blog/create")
    suspend fun addBlog(@Body blog: RemoteBlogItem): RemoteBlogItem
}
