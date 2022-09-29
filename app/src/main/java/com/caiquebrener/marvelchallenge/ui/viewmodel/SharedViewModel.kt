package com.caiquebrener.marvelchallenge.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caiquebrener.marvelchallenge.data.mappers.CharactersMapper
import com.caiquebrener.marvelchallenge.domain.usecase.getcomics.interfaces.GetComicsUseCase
import kotlinx.coroutines.launch

class SharedViewModel(private val useCase: GetComicsUseCase, private val mapper: CharactersMapper) : ViewModel() {

    private val _name = MutableLiveData("")
    var name: LiveData<String> = _name


    fun getCharacters(person: String) {
        viewModelScope.launch {
            val teste = mapper.toCharactersModel(useCase.getComics(person = person))
            teste.forEach {
                it.name?.let { it1 -> Log.i("Teste", it1) }
            }
            _name.postValue(teste[1].name)
        }
    }
}