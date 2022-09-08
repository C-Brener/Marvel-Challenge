package com.caiquebrener.marvelchallenge.data.model

data class EventList(
    val available: String,
    val collectionURI: String,
    val items: List<EventSummary>,
    val returned: String
)