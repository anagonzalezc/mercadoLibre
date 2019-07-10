package com.example.data.music.store

import com.example.data.music.model.MusicEntity
import com.example.data.music.repository.MusicDataStore
import com.example.data.music.repository.MusicRemote
import io.reactivex.Single
import javax.inject.Inject

class MusicRemoteDataStore @Inject constructor(
    private val musicRemote: MusicRemote)
    : MusicDataStore {

    override fun findMusicByText(text: String?): Single<List<MusicEntity>> {
        return musicRemote.findMusicByText(text)
    }
}