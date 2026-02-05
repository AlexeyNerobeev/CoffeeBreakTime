package com.example.coffeebreaktime.presentation.Profile

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreaktime.domain.UseCase.GetUserProfileUseCase
import com.example.coffeebreaktime.domain.model.Profile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileVM @Inject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase
): ViewModel() {
    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val profile = getUserProfileUseCase.invoke()
                _state.value = state.value.copy(
                    profile = profile
                )
            } catch (ex: Exception){
                Log.e("supabase", ex.message.toString())
            }
        }
    }
}