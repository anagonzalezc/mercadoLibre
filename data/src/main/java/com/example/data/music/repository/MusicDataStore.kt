package com.example.data.music.repository

import com.example.data.music.model.MusicEntity
import io.reactivex.Single

interface MusicDataStore {

    fun findMusicByText(text: String?): Single<List<MusicEntity>>

}