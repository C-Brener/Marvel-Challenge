package com.caiquebrener.marvelchallenge.data.model

data class Character(
    val comicList: ComicList,
    val description: String,
    val eventList: EventList,
    val id: String,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val seriesList: SeriesList,
    val storyList: StoryList,
    val image: Image,
    val urls: List<Url>
)