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

    private val _listComic = MutableLiveData<List<ComicsModel>>()
    val listComic: LiveData<List<ComicsModel>> = _listComic

    private val _comicDetail = MutableLiveData<ComicsModel>()
    var comicDetail:LiveData<ComicsModel> = _comicDetail
    init {
        getComics()
    }

    fun getComics(person: String? = null) {
        viewModelScope.launch {
            mapper.toComicsModel(useCase.getComics(person = person)).run {
                _listComic.postValue(this)
            }
        }
    }
    fun setComicsDetails(comicInformation:ComicsModel){
        _comicDetail.postValue(comicInformation)
    }
}
