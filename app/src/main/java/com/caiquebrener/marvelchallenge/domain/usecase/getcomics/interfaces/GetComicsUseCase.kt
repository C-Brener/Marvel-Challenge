package com.caiquebrener.marvelchallenge.domain.usecase.getcomics.interfaces

import com.caiquebrener.marvelchallenge.data.dto.getcomics.Comic

interface GetComicsUseCase {
    suspend fun getComics(person: String): List<Comic>
}