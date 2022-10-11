package com.caiquebrener.marvelchallenge.data.api

import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper
import retrofit2.http.GET
import retrofit2.http.Query


interface MarvelService {
    @GET("/v1/public/comics")
    suspend fun listCharacters(
        @Query("title") title: String?,
        @Query("ts") ts: String = "155",
        @Query("apikey") apikey: String = "537b2fb45d85090d5900e9d831923257",
        @Query("hash") hash: String = "b69f0d4a374a8f48ca9b126088e65e42"
    ): ComicDataWrapper
}