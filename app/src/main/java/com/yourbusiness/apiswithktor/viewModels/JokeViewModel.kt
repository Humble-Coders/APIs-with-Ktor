package com.yourbusiness.apiswithktor.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yourbusiness.apiswithktor.models.JokeResponse
import com.yourbusiness.apiswithktor.repositories.JokeRepository
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {
    // making a repo object to access the repository methods
    private val repository = JokeRepository()

    private val _joke = MutableLiveData<JokeResponse?>()
    val joke: LiveData<JokeResponse?> = _joke

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun fetchJoke() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _joke.value = repository.getJoke()
            } catch (e: Exception) {
                _joke.value = null
            }
            _isLoading.value = false
        }
    }
}