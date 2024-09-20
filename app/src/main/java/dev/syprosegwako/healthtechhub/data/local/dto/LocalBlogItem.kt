package dev.syprosegwako.healthtechhub.data.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blogs")
data class LocalBlogItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val surname: String,
    val subject: String,
    val body: String,
    @ColumnInfo(name = "topic_id") val topicId: Int,
    @ColumnInfo(name = "created_at")val createdAt: String,
    @ColumnInfo(name = "updated_at")val updatedAt: String
)