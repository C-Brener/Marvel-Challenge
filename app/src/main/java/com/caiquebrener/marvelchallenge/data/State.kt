package com.caiquebrener.marvelchallenge.data

import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper

sealed class State {
    data class Success(val comic: ComicDataWrapper) : State()
    object Error : State()
    object Loading : State()
}