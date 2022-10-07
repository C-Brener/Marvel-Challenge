package com.caiquebrener.marvelchallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caiquebrener.marvelchallenge.data.mappers.ComicsMapper
import com.caiquebrener.marvelchallenge.domain.usecase.getcomics.interfaces.GetComicsUseCase
import com.caiquebrener.marvelchallenge.ui.model.ComicsModel
import kotlinx.coroutines.launch

class SharedViewModel(private val useCase: GetComicsUseCase, private val mapper: ComicsMapper) : ViewModel() {

    private val _name = MutableLiveData<List<ComicsModel>>()
    var name: LiveData<List<ComicsModel>> = _name


    fun getComics(person: String? = null) {
        viewModelScope.launch {
            var teste = mapper.toComicsModel(useCase.getComics(person = person))
            _name.postValue(teste)
        }
    }
}