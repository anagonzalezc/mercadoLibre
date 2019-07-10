package com.example.itunesmusic.music.factory

import com.example.domain.music.model.Music
import com.example.itunesmusic.factory.RandomFactory
import com.example.itunesmusic.music.model.MusicView

object MoviesFactory {

    fun makeMusicList(count: Int): List<Music> {
        return (0..count).map { makeMusic() }
    }

    fun makeMusic(): Music {
        return Music(
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString()
        )
    }

    fun makeMovieViewList(count: Int): List<MusicView> {
        return (0..count).map { makeMovieView() }
    }

    fun makeMovieView(): MusicView {
        return MusicView(
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString()

        )
    }

}