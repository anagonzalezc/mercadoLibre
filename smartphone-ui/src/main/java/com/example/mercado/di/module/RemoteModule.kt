package com.example.mercado.di.module

import com.example.data.item.repository.ItemRemote
import com.example.mercado.helper.EndpointConstantsHelper
import com.example.remote.RemoteApiRestFactory
import com.example.remote.item.ItemRemoteImpl
import com.example.remote.item.SearchRestApi
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideMusicRestApi(): SearchRestApi {
            return RemoteApiRestFactory<SearchRestApi>().makeRemoteRestApi(
                    true, SearchRestApi::class.java, EndpointConstantsHelper.REST_API_SERVER
            )
        }
    }

    @Binds
    abstract fun bindMusicRemote(musicRemoteImpl: ItemRemoteImpl): ItemRemote
}