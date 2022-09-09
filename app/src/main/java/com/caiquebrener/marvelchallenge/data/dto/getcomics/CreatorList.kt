package com.caiquebrener.marvelchallenge.data.dto.getcomics

data class CreatorList(
    val available:Int,
    val returned:Int,
    val collectionURI:String,
    val items:List<CreatorSummary>
)
