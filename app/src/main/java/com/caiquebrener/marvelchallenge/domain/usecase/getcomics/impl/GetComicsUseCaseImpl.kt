package com.caiquebrener.marvelchallenge.domain.usecase.getcomics.impl

import com.caiquebrener.marvelchallenge.data.dto.getcomics.Comic
import com.caiquebrener.marvelchallenge.data.repository.comics.interfaces.ComicsRepository
import com.caiquebrener.marvelchallenge.domain.usecase.getcomics.interfaces.GetComicsUseCase

class GetComicsUseCaseImpl(private val repository: ComicsRepository) : GetComicsUseCase {
    override suspend fun getComics(person: String?): List<Comic> {
        return repository.getComicsApi(person).data.results
    }
}
