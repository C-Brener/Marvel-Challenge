package com.caiquebrener.marvelchallenge.data.model

data class SeriesList(
    val available: String,
    val collectionURI: String,
    val items: List<SeriesSummary>,
    val returned: String
)