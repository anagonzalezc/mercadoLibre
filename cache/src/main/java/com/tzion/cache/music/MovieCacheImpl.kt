package com.tzion.cache.music

import com.tzion.cache.CacheDatabase
import com.tzion.data.music.model.MusicEntity
import com.tzion.data.music.repository.MusicCache
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MovieCacheImpl @Inject constructor(
    private val cacheDatabase: CacheDatabase,
    private val mapper: CachedMovieMapper)
    :MusicCache {
    override fun findMusicByText(text: String?): Single<List<MusicEntity>> {
        return cacheDatabase.cachedMovieDao().getMovies().
            map {
                it.map { mapper.mapFromCached(it)
                }
            }    }


}