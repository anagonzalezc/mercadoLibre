package com.example.remote.music

import com.example.data.music.model.MusicEntity
import com.example.data.music.repository.MusicRemote
import io.reactivex.Single
import javax.inject.Inject

class MusicRemoteImpl @Inject constructor(
    private val restApi: MusicRestApi,
    private val mapper: MusicRemoteMapper)
    : MusicRemote {

    override fun findMusicByText(text: String?): Single<List<MusicEntity>> {
        return restApi.getMusic(text).map { search ->
            search.search.map { mapper.mapFromRemote(it) }
        }
    }

}