package com.example.coffeebreaktime.presentation.Barista

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreaktime.domain.UseCase.GetBaristaListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BaristaVM @Inject constructor(
    private val getBaristaListUseCase: GetBaristaListUseCase
): ViewModel() {
    private val _state = mutableStateOf(BaristaState())
    val state: State<BaristaState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val baristaList = getBaristaListUseCase.invoke()
                _state.value = state.value.copy(
                    baristaList = baristaList,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("ex", ex.message.toString())
            }
        }
    }
}