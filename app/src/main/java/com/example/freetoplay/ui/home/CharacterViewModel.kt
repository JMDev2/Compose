package com.example.freetoplay.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freetoplay.model.CharacterResponse
import com.example.freetoplay.repo.CharacterRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository): ViewModel() {

    private val _state = MutableStateFlow(emptyList<CharacterResponse>())
    val state: StateFlow<List<CharacterResponse>>
    get() = _state



    init {
        viewModelScope.launch {
            val characters = repository.getCharacters()
            _state.value = characters
        }


    }



}