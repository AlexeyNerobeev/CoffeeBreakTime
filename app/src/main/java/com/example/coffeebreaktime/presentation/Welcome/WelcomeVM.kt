package com.example.coffeebreaktime.presentation.Welcome

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeVM @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(WelcomeState())
    val state: State<WelcomeState> = _state

    init {
        viewModelScope.launch {
            delay(1500)
            _state.value = state.value.copy(
                next = true
            )
        }
    }
}