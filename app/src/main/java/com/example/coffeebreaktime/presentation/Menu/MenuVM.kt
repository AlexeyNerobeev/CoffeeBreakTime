package com.example.coffeebreaktime.presentation.Menu

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreaktime.domain.UseCase.GetCoffeeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuVM @Inject constructor(
    private val getCoffeeListUseCase: GetCoffeeListUseCase
): ViewModel() {
    private val _state = mutableStateOf(MenuState())
    val state: State<MenuState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val coffeeList = getCoffeeListUseCase.invoke()
                _state.value = state.value.copy(
                    coffeeList = coffeeList,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("supabase", ex.message.toString())
            }
        }
    }
}