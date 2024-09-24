package dev.syprosegwako.healthtechhub.data.remote.dto

import com.google.gson.annotations.SerializedName


data class RemoteTopicItem(
    val id: Int,
    val title: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String
)