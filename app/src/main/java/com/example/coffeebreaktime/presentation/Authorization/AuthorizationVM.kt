package com.example.coffeebreaktime.presentation.Authorization

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreaktime.domain.UseCase.AuthUseCase
import com.example.coffeebreaktime.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationVM @Inject constructor(
    private val authUseCase: AuthUseCase
): ViewModel() {
    private val _state = mutableStateOf(AuthorizationState())
    val state: State<AuthorizationState> = _state

    fun onEvent(event: AuthorizationEvent){
        when(event){
            is AuthorizationEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is AuthorizationEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            AuthorizationEvent.VisualChange -> {
                _state.value = state.value.copy(
                    visualTransform = !state.value.visualTransform
                )
            }

            AuthorizationEvent.SignIn -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        authUseCase.invoke(User(state.value.email, state.value.password))
                        _state.value = state.value.copy(
                            isComplete = true
                        )
                    } catch (ex: Exception){
                        Log.e("supabase", ex.message.toString())
                    }
                }
            }
        }
    }
}