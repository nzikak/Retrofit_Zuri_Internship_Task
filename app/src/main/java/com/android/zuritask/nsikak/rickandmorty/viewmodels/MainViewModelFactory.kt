package com.android.zuritask.nsikak.rickandmorty.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.zuritask.nsikak.rickandmorty.repository.Repository
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val repository: Repository):
 ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}