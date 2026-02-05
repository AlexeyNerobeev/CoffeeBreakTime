package com.example.coffeebreaktime.presentation.StartUp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartUpVM @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(StartUpState())
    val state: State<StartUpState> = _state

    init{
        viewModelScope.launch {
            delay(1500)
            _state.value = state.value.copy(
                next = true
            )
        }
    }
}