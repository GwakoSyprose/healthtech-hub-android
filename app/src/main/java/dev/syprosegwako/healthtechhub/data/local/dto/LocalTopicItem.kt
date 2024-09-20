package dev.syprosegwako.healthtechhub.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topics")
data class LocalTopicItem(
    @PrimaryKey val id: Int,
    val title: String,
    val createdAt: String,
    val updatedAt: String
)