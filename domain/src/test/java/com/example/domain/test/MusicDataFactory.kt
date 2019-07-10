package com.example.domain.test

import com.example.domain.music.model.Music
import java.util.*

object MusicDataFactory {

    fun makeMusicList(count: Int): List<Music> {
        val music = mutableListOf<Music>()
        repeat(count) {
            music.add(makeMusic())
        }
        return music
    }

    fun makeMusic(): Music {
        return Music(randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid())
    }

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }
}