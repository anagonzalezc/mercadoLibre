package com.example.mercado.di

import com.nhaarman.mockito_kotlin.mock
import com.example.data.item.repository.ItemRemote
import com.example.remote.item.SearchRestApi
import dagger.Module
import dagger.Provides

@Module
object TestRemoteModule {

    @Provides
    @JvmStatic
    fun providesSearchRestApi(): SearchRestApi {
        return mock()
    }

    @Provides
    @JvmStatic
    fun providesItemRemote(): ItemRemote {
        return mock()
    }

}