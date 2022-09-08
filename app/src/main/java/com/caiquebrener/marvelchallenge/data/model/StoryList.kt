package com.caiquebrener.marvelchallenge.data.model

data class StoryList(
    val available: String,
    val collectionURI: String,
    val items: List<StorySummary>,
    val returned: String
)