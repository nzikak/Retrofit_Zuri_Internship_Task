package com.android.zuritask.nsikak.rickandmorty.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ResultResponse(
    @Json(name = "results")
    val characters: List<Character>)
