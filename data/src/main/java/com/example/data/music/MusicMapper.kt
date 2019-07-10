package com.example.data.music

import com.example.data.EntityMapper
import com.example.data.music.model.MusicEntity
import com.example.domain.music.model.Music
import javax.inject.Inject

class MusicMapper @Inject constructor(): EntityMapper<MusicEntity, Music> {

    override fun mapFromEntity(entity: MusicEntity): Music {
        return Music(entity.artistId, entity.artistName, entity.collectionName, entity.trackName, entity.photo, entity.urlMusic)
    }

    override fun mapToEntity(domain: Music): MusicEntity {
        return MusicEntity(domain.id, domain.name, domain.collection, domain.track, domain.photo, domain.urlMusic)
    }


}