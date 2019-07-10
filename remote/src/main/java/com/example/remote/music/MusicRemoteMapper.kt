package com.example.remote.music

import com.example.data.music.model.MusicEntity
import com.example.remote.RemoteMapper
import com.example.remote.music.model.RemoteMusic
import javax.inject.Inject

open class MusicRemoteMapper @Inject constructor(): RemoteMapper<RemoteMusic, MusicEntity> {

    override fun mapFromRemote(remote: RemoteMusic): MusicEntity {
        return MusicEntity(remote.artistId, remote.artistName, remote.collectionName, remote.trackName, remote.photo, remote.urlMusic)
    }

}