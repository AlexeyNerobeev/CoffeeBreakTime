package com.example.coffeebreaktime.presentation.ForgotPassword

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordVM @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(ForgotPasswordState())
    val state: State<ForgotPasswordState> = _state

    fun onEvent(event: ForgotPasswordEvent){
        when(event){
            is ForgotPasswordEvent.EnteredEmail ->{
                _state.value = state.value.copy(
                    email = event.value
                )
            }

            ForgotPasswordEvent.ResetPassword -> {
                _state.value = state.value.copy(
                    isComplete = true
                )
            }
        }
    }
}