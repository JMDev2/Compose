package com.example.freetoplay.repo

import com.example.freetoplay.api.CharacterApi

import com.example.freetoplay.model.CharacterResponse

import javax.inject.Inject

class CharacterRepository @Inject constructor(private val api: CharacterApi) {
    suspend fun getCharacters(): List<CharacterResponse>{
        return api.getCharacters()
    }
}