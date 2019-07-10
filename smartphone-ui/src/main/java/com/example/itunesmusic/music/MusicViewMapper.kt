package com.example.itunesmusic.music

import com.example.itunesmusic.ViewMapper
import com.example.itunesmusic.music.model.MusicView
import com.example.presentation.music.model.MusicPresentation
import javax.inject.Inject

class MusicViewMapper @Inject constructor() : ViewMapper<MusicPresentation, MusicView> {

    override fun mapToView(presentation: MusicPresentation): MusicView {
        return MusicView(
            presentation.artistId,
            presentation.artistName,
            presentation.collectionName,
            presentation.trackName,
            presentation.photo,
            presentation.urlMusic
        )
    }

}