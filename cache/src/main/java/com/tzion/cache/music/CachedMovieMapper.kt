package com.tzion.cache.music

import com.tzion.cache.CacheMapper
import com.tzion.cache.music.model.CachedMovie
import com.tzion.data.music.model.MusicEntity
import javax.inject.Inject

open class CachedMovieMapper @Inject constructor(): CacheMapper<CachedMovie, MusicEntity> {

    override fun mapFromCached(cache: CachedMovie): MusicEntity {
        return MusicEntity(cache.id, cache.title, cache.year, cache.poster, cache.type, cache.id)
    }

    override fun mapToCached(entity: MusicEntity): CachedMovie {
        return CachedMovie(
            entity.artistId, entity.trackName, entity.photo,
            "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", entity.collectionName, "",
            "", "", "")
    }

}