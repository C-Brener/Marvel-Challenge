package com.caiquebrener.marvelchallenge.data.mappers

import com.caiquebrener.marvelchallenge.data.dto.getcomics.Comic
import com.caiquebrener.marvelchallenge.ui.model.CharactersModel

class CharactersMapper {
    fun toCharactersModel(comicApi: List<Comic>): List<CharactersModel> {
        return comicApi.map {
            CharactersModel(
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