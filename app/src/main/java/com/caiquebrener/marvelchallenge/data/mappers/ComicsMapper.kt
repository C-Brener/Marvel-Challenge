package com.caiquebrener.marvelchallenge.data.mappers

import com.caiquebrener.marvelchallenge.data.dto.getcomics.Comic
import com.caiquebrener.marvelchallenge.ui.model.ComicsModel

class ComicsMapper {
    fun toComicsModel(comicApi: List<Comic>): List<ComicsModel> {
        return comicApi.map {
            ComicsModel(
                name = it.title,
                description = it.description,
                url = getValidLinkApi(it).replace("http:", "https:"),
                id = it.id
            )
        }
    }

    private fun getValidLinkApi(it: Comic) =
        "${it.thumbnail.path}/portrait_xlarge.${it.thumbnail.extension}"
}