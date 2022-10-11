package com.caiquebrener.marvelchallenge.data.dto.getcomics

data class ComicDataContainer(
    val offset:Int,
    val limit:Int,
    val total:Int,
    val count:Int,
    val results:List<Comic>
)