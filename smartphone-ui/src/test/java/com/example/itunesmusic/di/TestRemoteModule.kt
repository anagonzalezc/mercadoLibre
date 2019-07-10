package com.example.itunesmusic.di

import com.nhaarman.mockito_kotlin.mock
import com.example.data.music.repository.MusicRemote
import com.example.remote.music.MusicRestApi
import dagger.Module
import dagger.Provides

@Module
object TestRemoteModule {

    @Provides
    @JvmStatic
    fun providesMusicRestApi(): MusicRestApi {
        return mock()
    }

    @Provides
    @JvmStatic
    fun providesMusicRemote(): MusicRemote {
        return mock()
    }

}