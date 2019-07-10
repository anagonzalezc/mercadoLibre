package com.example.data.test.factory

import com.segtechcu.data.test.factory.DataFactory
import com.example.data.music.model.MusicEntity
import com.example.domain.music.model.Music

object MusicFactory {

    fun makeMusicEntity(): MusicEntity{
        return MusicEntity(
            DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),DataFactory.randomString())
    }

    fun makeMusic(): Music {
        return Music(DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),DataFactory.randomString())
    }

}