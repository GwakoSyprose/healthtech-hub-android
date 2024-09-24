package dev.syprosegwako.healthtechhub.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.syprosegwako.healthtechhub.blog.domain.TopicItem
import dev.syprosegwako.healthtechhub.data.local.dto.LocalBlogItem
import dev.syprosegwako.healthtechhub.data.local.dto.LocalTopicItem

@Dao
interface TopicDao {
    @Query("SELECT * FROM topics")
    suspend fun getTopics() : List<LocalTopicItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTopics(blog: List<LocalTopicItem>)

}