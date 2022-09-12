package com.caiquebrener.marvelchallenge.domain.usecase.getcomics

import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper
import com.caiquebrener.marvelchallenge.data.repository.comics.ComicsRepository
import retrofit2.Call

class GetComicsUseCaseImpl(private val repository: ComicsRepository) : GetComicsUsecase {
    override fun getComics(person:String): Call<ComicDataWrapper> {
        return repository.getComicsApi(person = person)
    }
}