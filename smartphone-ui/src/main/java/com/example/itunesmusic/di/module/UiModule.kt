package com.example.itunesmusic.di.module

import com.example.domain.executor.PostExecutionThread
import com.example.itunesmusic.UiThread
import com.example.itunesmusic.music.displayMusic.DisplayMusicActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributeDisplayMusicActivity(): DisplayMusicActivity

}