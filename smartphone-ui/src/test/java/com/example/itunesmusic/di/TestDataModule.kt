package com.example.itunesmusic.di

import com.nhaarman.mockito_kotlin.mock
import com.example.domain.music.MusicRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TestDataModule {

    @Provides
    @JvmStatic
    @Singleton
    fun providesDataRepository(): MusicRepository {
        return mock()
    }

}