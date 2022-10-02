package com.caiquebrener.marvelchallenge.data.mappers

import com.caiquebrener.marvelchallenge.data.dto.getcomics.Comic
import com.caiquebrener.marvelchallenge.ui.model.CharactersModel

class CharactersMapper {
    fun toCharactersModel(comicApi: List<Comic>): List<CharactersModel> {
        var charactersModel = mutableListOf(CharactersModel())
        comicApi.forEach {
            charactersModel.add(
                CharactersModel(
                    name = it.title,
                    description = it.description,
                    url = getValidLinkApi(it).replace("http:","https:")
                )
            )
        }
        return charactersModel
    }

    private fun getValidLinkApi(it: Comic) =
        "${it.thumbnail.path}/landscape_xlarge.${it.thumbnail.extension}"
}