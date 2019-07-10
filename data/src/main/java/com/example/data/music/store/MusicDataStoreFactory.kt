package com.example.data.music.store

import com.example.data.music.repository.MusicDataStore
import javax.inject.Inject

class MusicDataStoreFactory @Inject constructor(
    private val musicRemoteDataStore: MusicRemoteDataStore) {

    open fun getDataStore(): MusicDataStore {
        return musicRemoteDataStore

    }

    open fun getRemoteDataStore(): MusicDataStore {
        return musicRemoteDataStore
    }

}