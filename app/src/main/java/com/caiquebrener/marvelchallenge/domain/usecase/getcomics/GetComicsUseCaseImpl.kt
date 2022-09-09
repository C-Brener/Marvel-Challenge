package com.caiquebrener.marvelchallenge.domain.usecase.getcomics

import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper
import com.caiquebrener.marvelchallenge.data.repository.getcomics.GetComicsRepository
import retrofit2.Call

class GetComicsUseCaseImpl(private val repository: GetComicsRepository) : GetComicsUsecase {
    override fun getComics(person:String): Call<ComicDataWrapper> {
        return repository.getComicsApi(person = person)
    }
}