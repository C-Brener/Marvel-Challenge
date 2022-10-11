package com.caiquebrener.marvelchallenge.data.dto.getcomics

data class CharactersList(
    val available:Int,
    val returned:Int,
    val collectionURI:String,
    val items:List<CharactersSummary>
)
