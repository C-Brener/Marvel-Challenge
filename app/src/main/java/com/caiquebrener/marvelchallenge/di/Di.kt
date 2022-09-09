package com.caiquebrener.marvelchallenge.di

import com.caiquebrener.marvelchallenge.data.mappers.CharactersMapper
import com.caiquebrener.marvelchallenge.ui.SharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Di {

    private val viewModel = module {
        viewModel { SharedViewModel() }
    }

    private val mappers = module {
        factory { CharactersMapper() }
    }


    val appModule = viewModel + mappers
}