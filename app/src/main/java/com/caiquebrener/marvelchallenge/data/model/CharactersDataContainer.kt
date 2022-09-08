package com.caiquebrener.marvelchallenge.data.model


data class CharactersDataContainer(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Character>
)
