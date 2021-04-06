package com.example.mercado.di

import android.app.Application
import com.example.domain.item.ItemRepository
import com.example.mercado.di.module.PresentationModule
import com.example.mercado.di.module.UiModule
import com.example.mercado.test.TestApplication
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

    fun musicRepository(): ItemRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestApplicationComponent.Builder

        fun build(): TestApplicationComponent
    }

    fun inject(application: TestApplication)

}