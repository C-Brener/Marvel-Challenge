package com.caiquebrener.marvelchallenge.infra.di

import com.caiquebrener.marvelchallenge.data.mappers.CharactersMapper
import com.caiquebrener.marvelchallenge.data.repository.comics.interfaces.ComicsRepository
import com.caiquebrener.marvelchallenge.data.repository.comics.impl.ComicsRespositoryImpl
import com.caiquebrener.marvelchallenge.domain.usecase.getcomics.impl.GetComicsUseCaseImpl
import com.caiquebrener.marvelchallenge.domain.usecase.getcomics.interfaces.GetComicsUseCase
import com.caiquebrener.marvelchallenge.ui.viewmodel.SharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


object Di {

    private val viewModel = module {
        viewModel { SharedViewModel(get(), get()) }
    }

    private val mappers = module {
        factory { CharactersMapper() }
    }

    private val repository = module {
        factory<ComicsRepository> { ComicsRespositoryImpl() }
    }

    private val usecase = module {
        factory<GetComicsUseCase> { GetComicsUseCaseImpl(get()) }
    }

    private val mapper = module {
        factory<CharactersMapper> { CharactersMapper() }
    }

    val appModule = viewModel + mappers + repository + usecase + mapper
}