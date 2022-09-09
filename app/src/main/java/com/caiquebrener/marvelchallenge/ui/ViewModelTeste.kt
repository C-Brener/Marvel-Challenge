package com.caiquebrener.marvelchallenge.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.caiquebrener.marvelchallenge.data.api.ApiService
import com.caiquebrener.marvelchallenge.data.dto.getcomics.ComicDataWrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelTeste : ViewModel() {
    private val _teste = MutableLiveData<List<ComicDataWrapper>>()
    var teste: LiveData<List<ComicDataWrapper>> = _teste

    private val _name = MutableLiveData("")
    var name: LiveData<String> = _name

    fun getCharacters() {
        ApiService.service.listCharacters().enqueue(object : Callback<ComicDataWrapper> {
            override fun onResponse(
                call: Call<ComicDataWrapper>,
                response: Response<ComicDataWrapper>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { Comic ->
                        for (comic in Comic.data.results) {
                            _name.postValue(comic.title)
                            Log.i("Teste", comic.title)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ComicDataWrapper>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}