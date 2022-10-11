package com.caiquebrener.marvelchallenge.data.dto.getcomics


data class Comic(
    val id:Int,
    val digitalId:Int,
    val title:String,
    val issueNumber:Double,
    val variantDescription:String,
    val description:String,
    val modified:String,
    val isbn:String,
    val upc:String,
    val diamondCode:String,
    val ean:String,
    val issn:String,
    val format:String,
    val pageCount:Int,
    val textObjects:List<TextObject>,
    val resourceURI:String,
    val urls:List<Url>,
    val series:SeriesSummary,
    val collections:List<ComicSummary>,
    val dates:List<ComicDate>,
    val prices:List<ComicPrice>,
    val thumbnail: Image,
    val images:List<Image>,
    val creators:CreatorList,
    val characters:CharactersList,
    val stories:StoryList,
    val events:EventList
)
