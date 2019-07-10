package com.example.itunesmusic.di

import android.app.Application
import com.example.domain.music.MusicRepository
import com.example.itunesmusic.di.module.PresentationModule
import com.example.itunesmusic.di.module.UiModule
import com.example.itunesmusic.test.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    TestApplicationModule::class,
    TestDataModule::class,
    PresentationModule::class,
    UiModule::class,
    TestRemoteModule::class])
interface TestApplicationComponent : ApplicationComponent {

    fun musicRepository(): MusicRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestApplicationComponent.Builder

        fun build(): TestApplicationComponent
    }

    fun inject(application: TestApplication)

}