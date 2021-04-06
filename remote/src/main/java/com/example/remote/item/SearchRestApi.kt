package com.example.remote.item

import com.example.remote.item.model.RemoteSearch
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRestApi {

    @GET("sites/MLC/search")
    fun getItem(@Query("q") searchCriteria: String?): Single<RemoteSearch>

}