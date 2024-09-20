package dev.syprosegwako.healthtechhub.data.local

import androidx.room.Dao
import androidx.room.Query
import dev.syprosegwako.healthtechhub.data.local.dto.LocalTopicItem

@Dao
interface TopicDao {
    @Query("SELECT * FROM topics")
    suspend fun getTopics() : List<LocalTopicItem>

}