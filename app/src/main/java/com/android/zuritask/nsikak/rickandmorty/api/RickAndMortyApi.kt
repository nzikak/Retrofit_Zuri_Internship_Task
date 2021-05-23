package com.android.zuritask.nsikak.rickandmorty.api

import com.android.zuritask.nsikak.rickandmorty.models.ResultResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://rickandmortyapi.com/"
interface RickAndMortyApiService {


    @GET("api/character")
    suspend fun getCharacters(): ResultResponse
}

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

object Api {
    val apiService: RickAndMortyApiService by lazy {
        retrofit.create(RickAndMortyApiService::class.java)
    }
}