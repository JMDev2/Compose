package com.example.freetoplay.api

import com.example.freetoplay.model.CharacterResponse
import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getCharacters(): List<CharacterResponse>
}