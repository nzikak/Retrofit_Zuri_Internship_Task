package com.android.zuritask.nsikak.rickandmorty.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Character(
    val name: String,
    val status: String,
    val species: String,
    @Json(name = "image")
    val imageUrl: String)