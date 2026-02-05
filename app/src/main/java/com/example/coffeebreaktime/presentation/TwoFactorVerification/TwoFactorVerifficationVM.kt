package com.example.coffeebreaktime.presentation.TwoFactorVerification

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TwoFactorVerificationVM @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(TwoFactorVerificationState())
    val state: State<TwoFactorVerificationState> = _state

    fun onEvent(event: TwoFactorVerificationEvent){
        when(event){
            is TwoFactorVerificationEvent.EnteredFirstNum -> {
                _state.value = state.value.copy(
                    firstNum = event.value
                )
            }
            is TwoFactorVerificationEvent.EnteredSecondNum -> {
                _state.value = state.value.copy(
                    secondNum = event.value
                )
            }
            is TwoFactorVerificationEvent.EnteredThirdNum -> {
                _state.value = state.value.copy(
                    thirdNum = event.value
                )
            }
            is TwoFactorVerificationEvent.EnteredFourthNum -> {
                _state.value = state.value.copy(
                    fourthNum = event.value
                )
            }
        }
    }
}