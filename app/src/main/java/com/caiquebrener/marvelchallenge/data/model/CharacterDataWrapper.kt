package com.caiquebrener.marvelchallenge.data.model

data class CharacterDataWrapper(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val data: CharactersDataContainer,
    val etag: String

)
