package com.caiquebrener.marvelchallenge.domain.usecase.getcomics

import com.caiquebrener.marvelchallenge.data.dto.getcomics.Comic
import com.caiquebrener.marvelchallenge.data.repository.comics.ComicsRepository

class GetComicsUseCaseImpl(private val repository: ComicsRepository) : GetComicsUsecase {
    override suspend fun getComics(person: String): List<Comic> {
        return repository.getComicsApi(person).data.results
    }
}
