package com.example.coffeebreaktime.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeebreaktime.Navigation
import com.example.coffeebreaktime.R

@Composable
fun BottomNavigationBar(
    navController: NavController,
    currentScreen: Navigation
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 25.dp)
            .padding(bottom = 22.dp)
            .fillMaxWidth()
            .height(64.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(20.dp),
                clip = false,
                spotColor = Color(0xFF324A591F).copy(alpha = 0.12f)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 56.dp)
                .padding(vertical = 22.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    if (currentScreen != Navigation.Menu) {
                        navController.navigate(Navigation.Menu)
                    }
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.shop_icon),
                    contentDescription = null,
                    tint = if (currentScreen == Navigation.Menu)
                        Color.Black
                    else
                        colorResource(R.color.bottomIcon),
                    modifier = Modifier
                        .size(21.dp)
                )
            }
            IconButton(
                onClick = {
                    if(currentScreen != Navigation.Reward){
                        navController.navigate(Navigation.Reward)
                    }
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.gift_icon),
                    contentDescription = null,
                    tint = if (currentScreen == Navigation.Reward)
                        Color.Black
                    else
                        colorResource(R.color.bottomIcon),
                    modifier = Modifier
                        .size(21.dp)
                )
            }
            IconButton(
                onClick = {
                    if(currentScreen != Navigation.MyOrderHistory){
                        navController.navigate(Navigation.MyOrderHistory)
                    }
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.order_icon),
                    contentDescription = null,
                    tint = if (currentScreen == Navigation.MyOrderHistory)
                        Color.Black
                    else
                        colorResource(R.color.bottomIcon),
                    modifier = Modifier
                        .size(21.dp)
                )
            }
        }
    }
}