package com.tzion.cache.music

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tzion.cache.music.MovieConstants.DELETE_MOVIES
import com.tzion.cache.music.MovieConstants.SELECT_MOVIES
import com.tzion.cache.music.model.CachedMovie
import io.reactivex.Single

@Dao
abstract class CachedMovieDao {

    @Query(SELECT_MOVIES)
    @JvmSuppressWildcards
    abstract fun getMovies(): Single<List<CachedMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract fun insertMovies(clients: List<CachedMovie>)

    @Query(DELETE_MOVIES)
    abstract fun deleteMovies()

}