package com.example.presentation.test.factory

import com.example.domain.music.model.Music
import com.example.presentation.music.model.MusicPresentation

object MusicFactory {

    fun makeMusicView(): MusicPresentation {
        return MusicPresentation(DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),DataFactory.randomString())
    }

    fun makeMusic(): Music {
        return Music(DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),DataFactory.randomString())
    }

    fun makeMusicViewList(count: Int): List<MusicPresentation> {
        val musics = mutableListOf<MusicPresentation>()
        repeat(count) {
            musics.add(makeMusicView())
        }
        return musics
    }

    fun makeMusicList(count: Int): List<Music> {
        val s = mutableListOf<Music>()
        repeat(count) {
            s.add(makeMusic())
        }
        return s
    }

}