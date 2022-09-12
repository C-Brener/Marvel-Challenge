package com.caiquebrener.marvelchallenge.infra.di

import com.caiquebrener.marvelchallenge.data.mappers.CharactersMapper
import com.caiquebrener.marvelchallenge.data.repository.comics.ComicsRepository
import com.caiquebrener.marvelchallenge.data.repository.comics.impl.ComicsRespositoryImpl
import com.caiquebrener.marvelchallenge.domain.usecase.getcomics.GetComicsUseCaseImpl
import com.caiquebrener.marvelchallenge.domain.usecase.getcomics.GetComicsUsecase
import com.caiquebrener.marvelchallenge.ui.viewmodel.SharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


object Di {

    private val viewModel = module {
        viewModel { SharedViewModel(get()) }
    }

    private val mappers = module {
        factory { CharactersMapper() }
    }

    private val repository = module {
        factory<ComicsRepository> { ComicsRespositoryImpl() }
    }

    private val usecase = module {
        factory<GetComicsUsecase> { GetComicsUseCaseImpl(get()) }
    }

    val appModule = viewModel + mappers + repository + usecase
}