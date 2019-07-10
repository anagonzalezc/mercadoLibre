package com.example.remote.test.factory

import com.example.data.music.model.MusicEntity
import com.example.remote.music.model.RemoteMusic
import com.example.remote.music.model.RemoteSearch


object MusicDataFactory {

    fun makeMusicResponse(): RemoteSearch {
        return RemoteSearch(makeListOfMusic())
    }

    fun makeListOfMusic(): List<RemoteMusic> {
        return listOf(makeMusic(), makeMusic())
    }

    fun makeMusic(): RemoteMusic {
        return RemoteMusic(DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
            DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid())
    }

    fun makeMusicEntity(): MusicEntity{
        return MusicEntity(DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
            DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid())
    }

}