package com.example.coffeebreaktime.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.coffeebreaktime.R

@Composable
fun ErrorAlertDialog(
    error: String,
    onClick: () -> Unit
){
    AlertDialog(
        onDismissRequest = {
            onClick()
        },
        text = {
            Text(text = error,
                fontSize = 24.sp)
        },
        title = {
            Text(text = stringResource(R.string.error),
                fontSize = 18.sp)
        },
        confirmButton = {
            Button(
                onClick = {
                    onClick()
                }
            ) {
                Text("OK")
            }
        }
    )
}