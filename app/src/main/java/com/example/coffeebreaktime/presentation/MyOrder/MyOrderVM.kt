package com.example.coffeebreaktime.presentation.MyOrder

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreaktime.domain.repository.OrderRepository
import com.example.coffeebreaktime.domain.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyOrderVM @Inject constructor(
    private val orderRepository: OrderRepository,
    private val profileRepository: ProfileRepository
): ViewModel() {
    private val _state = mutableStateOf(MyOrderState())
    val state: State<MyOrderState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val orderList = orderRepository.getOrderList()
                var total = 0
                for(item in orderList){
                    total += item.sum
                }
                val profile = profileRepository.getUserPay()
                _state.value = state.value.copy(
                    orderList = orderList,
                    total = total,
                    name = profile.name,
                    address = profile.address,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("ex", ex.message.toString())
                _state.value = state.value.copy(
                    error = true
                )
            }
        }
    }

    fun onEvent(event: MyOrderEvent){
        when(event){
            MyOrderEvent.ChangeError -> {
                _state.value = state.value.copy(
                    error = false
                )
            }
            MyOrderEvent.Pay -> {
                _state.value = state.value.copy(
                    pay = !state.value.pay
                )
            }
        }
    }
}