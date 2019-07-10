package com.example.presentation.music

import com.example.domain.music.model.Music
import com.example.presentation.PresentationMapper
import com.example.presentation.music.model.MusicPresentation
import javax.inject.Inject

open class MusicPresentationMapper @Inject constructor() : PresentationMapper<MusicPresentation, Music> {

    override fun mapToPresentation(domain: Music): MusicPresentation {
        return MusicPresentation(domain.id, domain.name, domain.collection, domain.track,domain.photo,domain.urlMusic)
    }

    override fun mapFromPresentation(presentation: MusicPresentation): Music {
        return Music(
            presentation.artistId,
            presentation.artistName,
            presentation.collectionName,
            presentation.trackName,
            presentation.photo,
            presentation.urlMusic
        )
    }

}