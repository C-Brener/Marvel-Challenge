package com.caiquebrener.marvelchallenge.data.repository.comics

import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper
import retrofit2.Call

interface ComicsRepository {
    fun getComicsApi(person:String): Call<ComicDataWrapper>
}