package dev.syprosegwako.healthtechhub.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.syprosegwako.healthtechhub.util.Constants.Database.TABLE_TOPICS

@Entity(tableName = TABLE_TOPICS)
data class LocalTopicItem(
    @PrimaryKey val id: Int,
    val title: String,
    val createdAt: String,
    val updatedAt: String
)