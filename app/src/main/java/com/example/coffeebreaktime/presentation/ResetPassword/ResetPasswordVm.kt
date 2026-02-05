package com.example.coffeebreaktime.presentation.ResetPassword

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.coffeebreaktime.domain.UseCase.IsPasswordValidUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetPasswordVM @Inject constructor(
    private val isPasswordValidUseCase: IsPasswordValidUseCase
): ViewModel() {
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
            ResetPasswordEvent.ErrorChange -> {
                _state.value = state.value.copy(
                    error = false
                )
            }

            ResetPasswordEvent.PasswordChange -> {
                val isValid = isPasswordValidUseCase.invoke(state.value.password)
                if(isValid){
                    _state.value = state.value.copy(
                        isComplete = true
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