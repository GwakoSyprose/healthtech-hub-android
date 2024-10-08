package dev.syprosegwako.healthtechhub.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.syprosegwako.healthtechhub.blog.domain.repository.BlogRepository
import dev.syprosegwako.healthtechhub.blog.domain.repository.BlogRepositoryImpl
import dev.syprosegwako.healthtechhub.blog.domain.repository.TopicRepository
import dev.syprosegwako.healthtechhub.blog.domain.repository.TopicRepositoryImpl
import dev.syprosegwako.healthtechhub.data.local.BlogDao
import dev.syprosegwako.healthtechhub.data.local.BlogDatabase
import dev.syprosegwako.healthtechhub.data.local.TopicDao
import dev.syprosegwako.healthtechhub.data.remote.BlogApi
import dev.syprosegwako.healthtechhub.core.util.Constants.Database.DATABASE_NAME
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): BlogDatabase {
        return Room.databaseBuilder(
            context,
            BlogDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideBlogDao(db: BlogDatabase): BlogDao {
        return db.blogDao
    }

    @Provides
    fun provideTopicDao(db: BlogDatabase): TopicDao {
        return db.topicDao
    }

    @Provides
    @Singleton
    fun provideBlogRepository(db: BlogDatabase, api: BlogApi, @IoDispatcher dispatcher: CoroutineDispatcher): BlogRepository {
        return BlogRepositoryImpl(db.blogDao, api, dispatcher)
    }

    @Provides
    @Singleton
    fun provideTopicRepository(db: BlogDatabase, api: BlogApi, @IoDispatcher dispatcher: CoroutineDispatcher): TopicRepository {
        return TopicRepositoryImpl(db.topicDao, api, dispatcher)
    }


}