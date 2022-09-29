package com.caiquebrener.marvelchallenge.data.repository.comics.interfaces

import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper

interface ComicsRepository {
    suspend fun getComicsApi(person:String): ComicDataWrapper
}