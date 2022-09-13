package com.caiquebrener.marvelchallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caiquebrener.marvelchallenge.domain.usecase.getcomics.GetComicsUsecase
import kotlinx.coroutines.launch

class SharedViewModel(private val useCase: GetComicsUsecase) : ViewModel() {

    private val _name = MutableLiveData("")
    var name: LiveData<String> = _name


    fun getCharacters(person: String) {
        viewModelScope.launch {
            _name.postValue(useCase.getComics(person = person)[0].title)
        }
    }
}