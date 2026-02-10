package com.example.coffeebreaktime.presentation.CoffeeType

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreaktime.domain.repository.CoffeeTypeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeTypeVM @Inject constructor(
    private val coffeeTypeRepository: CoffeeTypeRepository
): ViewModel() {
    private val _state = mutableStateOf(CoffeeTypeState())
    val state: State<CoffeeTypeState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val coffeeList = coffeeTypeRepository.getCoffeeTypeList()
                _state.value = state.value.copy(
                    coffeeList = coffeeList,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("supabase", ex.message.toString())
                _state.value = state.value.copy(
                    error = true
                )
            }
        }
    }

    fun onEvent(event: CoffeeTypeEvent){
        when(event){
            CoffeeTypeEvent.ChangeError -> {
                _state.value = state.value.copy(
                    error = false
                )
            }
        }
    }
}