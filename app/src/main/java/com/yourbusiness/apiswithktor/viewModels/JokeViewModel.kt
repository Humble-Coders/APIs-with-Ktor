package com.yourbusiness.apiswithktor.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yourbusiness.apiswithktor.models.JokeResponse
import com.yourbusiness.apiswithktor.repositories.JokeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {
    private val repository = JokeRepository()

    private val _joke = MutableStateFlow<JokeResponse?>(null)
    val joke: StateFlow<JokeResponse?> = _joke.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun fetchJoke() {
        viewModelScope.launch {
            _isLoading.value = true
            _joke.value = repository.getJoke()
            _isLoading.value = false
        }
    }
}

