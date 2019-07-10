package com.example.domain.music

import com.example.domain.music.model.Music
import io.reactivex.Single

interface MusicRepository {

    fun findMusicByText(text: String?): Single<List<Music>>

}