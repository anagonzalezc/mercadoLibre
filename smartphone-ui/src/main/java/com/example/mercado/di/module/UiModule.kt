package com.example.mercado.di.module

import com.example.domain.executor.PostExecutionThread
import com.example.mercado.UiThread
import com.example.mercado.item.displayItem.DisplayItemActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributeDisplayMusicActivity(): DisplayItemActivity

}