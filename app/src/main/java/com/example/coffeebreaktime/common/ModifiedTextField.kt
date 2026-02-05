package com.example.coffeebreaktime.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun ModifiedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: Int,
    testTag: String,
    placeholder: String,
    trailingIcon: Boolean,
    visualTransform: Boolean,
    visualChange: () -> Unit,
    padding: Int
) {
    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        modifier = Modifier
            .testTag(testTag)
            .padding(top = padding.dp)
            .fillMaxWidth(),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedTextColor = Theme.colors.oppositeColor,
            unfocusedTextColor = Theme.colors.oppositeColor,
            unfocusedIndicatorColor = colorResource(R.color.tfColor),
            focusedIndicatorColor = colorResource(R.color.tfColor)
        ),
        leadingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(leadingIcon),
                    contentDescription = null,
                    tint = Theme.colors.tfIconColor)
                Box(modifier = Modifier
                    .padding(start = 9.dp)
                    .size(height = 26.dp, width = 1.dp)
                    .background(colorResource(R.color.tfColor)))
            }
        },
        trailingIcon = {
            if (trailingIcon){
                IconButton(
                    onClick = {
                        visualChange()
                    }
                ) {
                    Icon(painter = painterResource(R.drawable.eye_icon),
                        contentDescription = null,
                        tint = Theme.colors.eyeColor)
                }
            }
        },
        visualTransformation = if (trailingIcon){
            if (visualTransform)
                PasswordVisualTransformation('*')
            else
                VisualTransformation.None
        } else{
            VisualTransformation.None
        },
        placeholder = {
            Text(text = placeholder,
                color = colorResource(R.color.tfColor),
                fontFamily = roboto,
                fontWeight = FontWeight(500),
                fontSize = 12.sp)
        }
    )
}