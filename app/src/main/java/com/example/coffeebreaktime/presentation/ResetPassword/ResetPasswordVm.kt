package com.example.coffeebreaktime.presentation.ResetPassword

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetPasswordVM @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(ResetPasswordState())
    val state: State<ResetPasswordState> = _state

    fun onEvent(event: ResetPasswordEvent){
        when(event){
            is ResetPasswordEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }

            ResetPasswordEvent.VisualChange -> {
                _state.value = state.value.copy(
                    visualTransform = !state.value.visualTransform
                )
            }
        }
    }
}