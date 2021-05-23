package com.android.zuritask.nsikak.rickandmorty.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.zuritask.nsikak.rickandmorty.models.Character
import com.android.zuritask.nsikak.rickandmorty.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    private val _characters = MutableLiveData<List<Character>>()
    internal val characters: LiveData<List<Character>>
    get() = _characters

    init {
        getCharacters()
    }


    internal fun getCharacters() {
        viewModelScope.launch {
            val characters = repository.getCharacters().characters
            _characters.value = characters
        }
    }
}