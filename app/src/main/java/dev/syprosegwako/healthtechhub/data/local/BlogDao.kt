package dev.syprosegwako.healthtechhub.data.local


import dev.syprosegwako.healthtechhub.data.local.dto.LocalBlogItem
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlogDao {
    @Query("SELECT * FROM blogs")
    suspend fun getBlogs(): List<LocalBlogItem>

    @Query("SELECT * FROM blogs WHERE id = :id")
    suspend fun getBlogById(id: Int): LocalBlogItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBlogs(blog: List<LocalBlogItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBlog(blog: LocalBlogItem): Long

}