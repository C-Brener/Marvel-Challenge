package com.caiquebrener.marvelchallenge.data.repository.getcomics

import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper
import retrofit2.Call

interface GetComicsRepository {
    fun getComicsApi(person:String): Call<ComicDataWrapper>
}