package com.example.mercado.di

import com.nhaarman.mockito_kotlin.mock
import com.example.domain.item.ItemRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TestDataModule {

    @Provides
    @JvmStatic
    @Singleton
    fun providesDataRepository(): ItemRepository {
        return mock()
    }

}