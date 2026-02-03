package com.example.coffeebreaktime.common

import com.yandex.mapkit.map.PlacemarkText

data class TextFieldData(
    val value: String,
    val onValueChange: (String) -> Unit,
    val leadingIcon: Int,
    val testTag: String,
    val placeholder: String,
    val trailingIcon: Boolean,
    val visualTransform: Boolean,
    val visualChange: () -> Unit,
    val padding: Int
)