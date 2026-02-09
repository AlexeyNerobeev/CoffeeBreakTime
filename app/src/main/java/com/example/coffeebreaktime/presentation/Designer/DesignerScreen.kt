package com.example.coffeebreaktime.presentation.Designer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeebreaktime.Navigation
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun DesignerScreen(navController: NavController) {
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.arrow_left),
                            contentDescription = null,
                            tint = Theme.colors.backIcon
                        )
                    }
                    Text(
                        text = stringResource(R.string.constructor_coffeeman),
                        color = Theme.colors.orderOptionsTitle,
                        fontWeight = FontWeight(500),
                        fontFamily = roboto,
                        fontSize = 16.sp
                    )
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            painterResource(R.drawable.cart_icon),
                            contentDescription = null,
                            tint = Theme.colors.backIcon
                        )
                    }
                }
                Text(text = stringResource(R.string.choose_barista),
                    modifier = Modifier
                        .padding(top = 39.dp)
                        .clickable {
                            navController.navigate(Navigation.Barista)
                        })
                Text(text = stringResource(R.string.sort_coffee),
                    modifier = Modifier
                        .padding(top = 14.dp)
                        .clickable {
                            navController.navigate(Navigation.Country)
                        })
                Text(text = stringResource(R.string.additives),
                    modifier = Modifier
                        .padding(top = 14.dp)
                        .clickable {

                        })

            }
        }
    }
}