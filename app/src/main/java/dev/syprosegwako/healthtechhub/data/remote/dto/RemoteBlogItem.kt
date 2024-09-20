package dev.syprosegwako.healthtechhub.data.remote.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class RemoteBlogItem(
    val id: Int?,
    val name: String,
    val surname: String,
    val subject: String,
    val body: String,
    @SerializedName("topic_id") val topicId: Int,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String
)

