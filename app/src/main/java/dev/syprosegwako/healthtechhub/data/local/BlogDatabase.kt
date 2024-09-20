package dev.syprosegwako.healthtechhub.data.local

import dev.syprosegwako.healthtechhub.data.local.dto.LocalBlogItem
import androidx.room.Database
import androidx.room.RoomDatabase
import dev.syprosegwako.healthtechhub.data.local.dto.LocalTopicItem

@Database(
    entities = [LocalBlogItem::class, LocalTopicItem::class],
    version = 1,
    exportSchema = false
)
abstract class BlogDatabase: RoomDatabase(){
    abstract val blogDao: BlogDao
    abstract val topicDao: TopicDao

    companion object{
        const val DATABASE_NAME = "blog_db"
    }
}
