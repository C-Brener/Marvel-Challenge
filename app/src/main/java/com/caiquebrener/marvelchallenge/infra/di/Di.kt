package com.caiquebrener.marvelchallenge.infra.di

import com.caiquebrener.marvelchallenge.data.mappers.ComicsMapper
import com.caiquebrener.marvelchallenge.data.repository.comics.interfaces.ComicsRepository
import com.caiquebrener.marvelchallenge.data.repository.comics.impl.ComicsRepositoryImpl
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
        factory { ComicsMapper() }
    }

    private val repository = module {
        factory<ComicsRepository> { ComicsRepositoryImpl() }
    }

    private val usecase = module {
        factory<GetComicsUseCase> { GetComicsUseCaseImpl(get()) }
    }

    private val mapper = module {
        factory<ComicsMapper> { ComicsMapper() }
    }

    val appModule = viewModel + mappers + repository + usecase + mapper
}