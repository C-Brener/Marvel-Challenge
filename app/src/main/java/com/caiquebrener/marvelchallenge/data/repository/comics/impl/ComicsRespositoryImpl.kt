package com.caiquebrener.marvelchallenge.data.repository.comics.impl

import com.caiquebrener.marvelchallenge.data.api.ApiService.service
import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper
import com.caiquebrener.marvelchallenge.data.repository.comics.ComicsRepository
import retrofit2.Call

class ComicsRespositoryImpl() : ComicsRepository {
    override fun getComicsApi(person: String): Call<ComicDataWrapper> {
        return service.listCharacters(person)
    }
}