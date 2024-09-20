package dev.syprosegwako.healthtechhub.data.remote.dto

import kotlinx.serialization.SerialName


data class RemoteTopicItem(
    val id: Int,
    val title: String,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String
)