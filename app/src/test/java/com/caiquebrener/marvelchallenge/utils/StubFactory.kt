package com.caiquebrener.marvelchallenge.utils

import com.caiquebrener.marvelchallenge.data.dto.getcomics.*
import com.caiquebrener.marvelchallenge.ui.model.ComicsModel
import io.mockk.mockk

class StubFactory {

    fun comicStub(): Comic {
        return Comic(
            id =1,
            digitalId =2,
            title ="Hulk contra o mundo",
            issueNumber =3.0,
            variantDescription ="Hulk Contra o mundo",
            description ="Hulk Contra o mundo",
            modified ="Hulk Contra o mundo",
            isbn ="Blabla",
            upc ="XPTO",
            diamondCode ="XPTO",
            ean ="XPTO",
            issn ="XPTO",
            format ="XPTO",
            pageCount =2,
            textObjects = listOf(textObject()),
            resourceURI ="XPTO",
            urls = listOf(url()),
            series = seriesSummary(),
            collections = listOf(),
            dates = listOf(),
            prices = listOf(),
            thumbnail = image(),
            images = listOf(),
            creators= mockk(relaxed = true),
            characters = mockk(relaxed = true),
            stories = mockk(relaxed = true),
            events = mockk(relaxed = true)
        )
    }

    private fun image() =
        Image("http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available", extension = "jpg")

    private fun seriesSummary() = SeriesSummary(resourceURI = "google.com", name = "google")

    private fun url() = Url(type = "http", "google.com")

    private fun textObject() = TextObject(language = "XPTO", text = "XPTO", type = "XPTO")

    fun comicsModelStub(): ComicsModel {
        return ComicsModel(
            name = "Hulk contra o mundo",
            1,
            "https://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available/portrait_xlarge.jpg",
            "Hulk Contra o mundo"
        )
    }
}