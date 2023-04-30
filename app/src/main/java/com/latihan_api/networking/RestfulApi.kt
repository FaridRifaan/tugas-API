package com.latihan_api.networking

import com.latihan_api.model.TvTopRated
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestfulApi {

    @GET("tv/top_rated")
    fun getTvTopRated(
        @Query("api_key") APIKEY: String,
        @Query("page") PAGE: Int
    ): Call<TvTopRated<com.latihan_api.model.Result>>

}