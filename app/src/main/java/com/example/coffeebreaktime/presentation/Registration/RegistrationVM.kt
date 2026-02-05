package com.example.coffeebreaktime.presentation.Registration

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreaktime.domain.UseCase.RegistrationUseCase
import com.example.coffeebreaktime.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationVM @Inject constructor(
    private val registrationUseCase: RegistrationUseCase
): ViewModel() {
    private val _state = mutableStateOf(RegistrationState())
    val state: State<RegistrationState> = _state

    fun onEvent(event: RegistrationEvent){
        when(event){
            RegistrationEvent.Checked -> {
                _state.value = state.value.copy(
                    checked = !state.value.checked
                )
            }
            is RegistrationEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is RegistrationEvent.EnteredName -> {
                _state.value = state.value.copy(
                    name = event.value
                )
            }
            is RegistrationEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            is RegistrationEvent.EnteredPhone -> {
                _state.value = state.value.copy(
                    phone = event.value
                )
            }
            RegistrationEvent.VisualChange -> {
                _state.value = state.value.copy(
                    visualTransform = !state.value.visualTransform
                )
            }

            RegistrationEvent.SignUp -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        registrationUseCase.invoke(User(email = state.value.email,
                            password = state.value.password))
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