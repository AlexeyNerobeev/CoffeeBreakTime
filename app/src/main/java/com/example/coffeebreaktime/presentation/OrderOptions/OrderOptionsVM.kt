package com.example.coffeebreaktime.presentation.OrderOptions

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderOptionsVM @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(OrderOptionsState())
    val state: State<OrderOptionsState> = _state

    fun onEvent(event: OrderOptionsEvent){
        when(event){
            OrderOptionsEvent.MinusCount -> {
                if(state.value.count > 0){
                    val newCount = state.value.count - 1
                    _state.value = state.value.copy(
                        count = newCount
                    )
                }
            }
            OrderOptionsEvent.PlusCount -> {
                val newCount = state.value.count + 1
                _state.value = state.value.copy(
                    count = newCount
                )
            }

            OrderOptionsEvent.SwitchChange -> {
                _state.value = state.value.copy(
                    switch = !state.value.switch
                )
            }
        }
    }
}