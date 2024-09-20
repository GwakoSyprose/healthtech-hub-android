package dev.syprosegwako.healthtechhub.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.syprosegwako.healthtechhub.data.remote.BlogApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://demo.api.nuvoteq.io/api/")
            .build()
    }

    @Provides
    fun provideBlogApi(retrofit: Retrofit): BlogApi {
        return retrofit.create(BlogApi::class.java)
    }


}