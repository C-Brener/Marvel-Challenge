package com.caiquebrener.marvelchallenge.data.repository.comics.impl

import com.caiquebrener.marvelchallenge.data.api.ApiService.service
import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper
import com.caiquebrener.marvelchallenge.data.repository.comics.interfaces.ComicsRepository

class ComicsRepositoryImpl() : ComicsRepository {
    override suspend fun getComicsApi(person: String?): ComicDataWrapper {
        return service.listCharacters(person)
    }
}