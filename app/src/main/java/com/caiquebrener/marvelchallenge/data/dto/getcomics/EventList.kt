package com.caiquebrener.marvelchallenge.data.dto.getcomics

data class EventList(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<EventSummary>
)
