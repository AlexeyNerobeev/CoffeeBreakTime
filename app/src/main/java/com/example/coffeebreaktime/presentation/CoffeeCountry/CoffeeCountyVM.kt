package com.example.coffeebreaktime.presentation.CoffeeCountry

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreaktime.domain.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeCountyVM @Inject constructor(
    private val countryRepository: CountryRepository
): ViewModel() {
    private val _state = mutableStateOf(CoffeeCountryState())
    val state: State<CoffeeCountryState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val countryList = countryRepository.getCountryList()
                _state.value = state.value.copy(
                    countryLis = countryList,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("supabase", ex.message.toString())
            }
        }
    }
}