package com.caiquebrener.marvelchallenge.domain.usecase.getcomics

import com.caiquebrener.marvelchallenge.data.dto.getcomics.Comic

interface GetComicsUsecase {
    suspend fun getComics(person: String): List<Comic>
}