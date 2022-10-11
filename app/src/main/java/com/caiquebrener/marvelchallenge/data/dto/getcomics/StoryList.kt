package com.caiquebrener.marvelchallenge.data.dto.getcomics

data class StoryList(
    val available:Int,
    val returned:Int,
    val collectionURI:String,
    val items:List<StorySummary>
)
