package com.caiquebrener.marvelchallenge.data.model

data class ComicList(
    val available: String,
    val collectionURI: String,
    val items: List<ComicSummary>,
    val returned: String
)