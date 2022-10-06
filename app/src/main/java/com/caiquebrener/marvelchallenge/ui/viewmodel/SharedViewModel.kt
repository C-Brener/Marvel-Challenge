package com.caiquebrener.marvelchallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caiquebrener.marvelchallenge.data.mappers.CharactersMapper
import com.caiquebrener.marvelchallenge.domain.usecase.getcomics.interfaces.GetComicsUseCase
import com.caiquebrener.marvelchallenge.ui.model.CharactersModel
import kotlinx.coroutines.launch

class SharedViewModel(private val useCase: GetComicsUseCase, private val mapper: CharactersMapper) : ViewModel() {

    private val _name = MutableLiveData<List<CharactersModel>>()
    var name: LiveData<List<CharactersModel>> = _name


    fun getCharacters(person: String? = null) {
        viewModelScope.launch {
            var teste = mapper.toCharactersModel(useCase.getComics(person = person))
            _name.postValue(teste)
        }
    }
}