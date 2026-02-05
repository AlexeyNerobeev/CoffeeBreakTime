package com.example.coffeebreaktime.presentation.TwoFactorVerification

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TwoFactorVerificationVM @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(TwoFactorVerificationState())
    val state: State<TwoFactorVerificationState> = _state

    init {
        viewModelScope.launch {
            while (state.value.seconds > 0){
                delay(1000)
                _state.value = state.value.copy(
                    seconds = state.value.seconds - 1
                )
            }
        }
    }

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
            TwoFactorVerificationEvent.ChangeError -> {
                _state.value = state.value.copy(
                    error = false
                )
            }
            TwoFactorVerificationEvent.GoNext -> {
                if(state.value.firstNum.isNotEmpty() &&
                    state.value.secondNum.isNotEmpty() &&
                    state.value.thirdNum.isNotEmpty() &&
                    state.value.fourthNum.isNotEmpty()) {
                    _state.value = state.value.copy(
                        next = true
                    )
                } else{
                    _state.value = state.value.copy(
                        error = true
                    )
                }
            }
        }
    }
}