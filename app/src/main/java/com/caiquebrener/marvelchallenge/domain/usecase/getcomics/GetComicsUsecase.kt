package com.caiquebrener.marvelchallenge.domain.usecase.getcomics

import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper
import retrofit2.Call

interface GetComicsUsecase {
    fun getComics(person:String): Call<ComicDataWrapper>
}