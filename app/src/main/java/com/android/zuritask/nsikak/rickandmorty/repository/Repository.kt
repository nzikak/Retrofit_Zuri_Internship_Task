package com.android.zuritask.nsikak.rickandmorty.repository

import com.android.zuritask.nsikak.rickandmorty.api.RickAndMortyApiService

class Repository(private val apiService: RickAndMortyApiService) {


    suspend fun getCharacters() = apiService.getCharacters()
}