package com.caiquebrener.marvelchallenge.data.repository.getcomics.impl

import com.caiquebrener.marvelchallenge.data.api.ApiService.service
import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper
import com.caiquebrener.marvelchallenge.data.repository.getcomics.GetComicsRepository
import retrofit2.Call

class GetComicsRespositoryImpl() : GetComicsRepository {
    override fun getComicsApi(person: String): Call<ComicDataWrapper> {
        return service.listCharacters(person)
    }
}