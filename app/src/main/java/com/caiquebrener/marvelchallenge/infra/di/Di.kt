package com.caiquebrener.marvelchallenge.infra.di

import com.caiquebrener.marvelchallenge.data.mappers.CharactersMapper
import com.caiquebrener.marvelchallenge.data.repository.getcomics.GetComicsRepository
import com.caiquebrener.marvelchallenge.data.repository.getcomics.impl.GetComicsRespositoryImpl
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
        factory<GetComicsRepository> { GetComicsRespositoryImpl() }
    }

    private val usecase = module {
        factory<GetComicsUsecase> { GetComicsUseCaseImpl(get()) }
    }

    val appModule = viewModel + mappers + repository + usecase
}