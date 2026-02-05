package com.example.coffeebreaktime.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun VerificationTextField(
    value: String,
    onValueChange: (String) -> Unit,
    padding: Int
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        modifier = Modifier
            .padding(start = padding.dp)
            .background(
                color = Theme.colors.verificationTf,
                shape = RoundedCornerShape(10.dp)
            )
            .size(48.dp, 61.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = if (value.isNotEmpty())
                colorResource(R.color.grayColor)
            else
                Theme.colors.verificationTf,
            unfocusedContainerColor = if (value.isNotEmpty())
                colorResource(R.color.grayColor)
            else
                Theme.colors.verificationTf,
            focusedBorderColor = if (value.isNotEmpty())
                colorResource(R.color.grayColor)
            else
                Theme.colors.verificationTf,
            unfocusedBorderColor = if (value.isNotEmpty())
                colorResource(R.color.grayColor)
            else
                Theme.colors.verificationTf,
            focusedTextColor = Theme.colors.oppositeColor,
            unfocusedTextColor = Theme.colors.oppositeColor
        ),
        shape = RoundedCornerShape(10.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        textStyle = TextStyle(textAlign = TextAlign.Center),
        singleLine = true
    )
}