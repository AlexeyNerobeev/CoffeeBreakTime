package com.example.coffeebreaktime.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeebreaktime.Navigation
import com.example.coffeebreaktime.R

@Composable
fun ChooseCoffeeShopButtons(
    text: String,
    padding: Int,
    navController: NavController
) {
    Box(modifier = Modifier
        .padding(top = padding.dp)
        .fillMaxWidth()
        .background(color = colorResource(R.color.mainColor),
            shape = RoundedCornerShape(16.dp)
        )
        .clickable{
            navController.navigate(Navigation.StartUpScreen)
        }){
        Row(modifier = Modifier
            .padding(vertical = 14.dp)
            .padding(start = 17.dp)
            .padding(end = 13.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(R.drawable.shop_icon),
                    contentDescription = null,
                    tint = Color.Unspecified)
                Text(text = text,
                    color = Color.White,
                    fontWeight = FontWeight(600),
                    fontSize = 14.sp,
                    fontFamily = roboto,
                    modifier = Modifier
                        .padding(start = 11.dp))
            }
            Icon(painter = painterResource(R.drawable.more_icon),
                contentDescription = null,
                tint = Color.White)
        }
    }
}