package com.example.itunesmusic.di.module

import com.example.data.music.MusicDataRepository
import com.example.domain.music.MusicRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: MusicDataRepository): MusicRepository

}