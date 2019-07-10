package com.example.itunesmusic.di.module

import com.example.data.music.repository.MusicRemote
import com.example.itunesmusic.helper.EndpointConstantsHelper
import com.example.remote.RemoteApiRestFactory
import com.example.remote.music.MusicRemoteImpl
import com.example.remote.music.MusicRestApi
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideMusicRestApi(): MusicRestApi {
            return RemoteApiRestFactory<MusicRestApi>().makeRemoteRestApi(
                    true, MusicRestApi::class.java, EndpointConstantsHelper.REST_API_SERVER
            )
        }
    }

    @Binds
    abstract fun bindMusicRemote(musicRemoteImpl: MusicRemoteImpl): MusicRemote
}