package com.example.data.music

import com.example.data.music.repository.MusicCache
import com.example.data.music.store.MusicDataStoreFactory
import com.example.domain.music.MusicRepository
import com.example.domain.music.model.Music
import io.reactivex.Single
import javax.inject.Inject

class MusicDataRepository @Inject constructor(
    private val mapper: MusicMapper,
    private val factory: MusicDataStoreFactory
)
    : MusicRepository {

    override fun findMusicByText(text: String?): Single<List<Music>> {
        return factory.getRemoteDataStore().findMusicByText(text).map {
            it.map {
                mapper.mapFromEntity(it)
            }
        }

    }

}