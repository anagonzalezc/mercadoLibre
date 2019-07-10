package com.example.remote.music

import com.example.remote.music.model.RemoteSearch
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicRestApi {

    @GET("/search")
    fun getMusic(@Query("term") searchCriteria: String?): Single<RemoteSearch>

}