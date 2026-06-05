package com.example.appmarket.di

import com.example.appmarket.data.Repository
import com.example.appmarket.data.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRepository(): Repository{
        return RepositoryImpl()
    }
}