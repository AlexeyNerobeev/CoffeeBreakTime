package com.example.coffeebreaktime.presentation.Reward

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeebreaktime.Navigation
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.common.BottomNavigationBar
import com.example.coffeebreaktime.common.dmSans
import com.example.coffeebreaktime.common.poppins
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun RewardScreen(navController: NavController) {
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)) {
            Text(text = stringResource(R.string.reward),
                color = Theme.colors.oppositeColor,
                fontFamily = roboto,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 21.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Column(modifier = Modifier
                .padding(top = 31.dp)
                .padding(horizontal = 25.dp)
                .fillMaxWidth()) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = colorResource(R.color.agree),
                        shape = RoundedCornerShape(12.dp)
                    )){
                    Column(modifier = Modifier
                        .padding(top = 14.dp)
                        .padding(bottom = 49.dp)
                        .padding(start = 34.dp)
                        .padding(end = 28.dp)
                        .fillMaxWidth()) {
                        Row(verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()) {
                            Text(text = stringResource(R.string.loyalty_card),
                                color = Color.White,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp
                            )
                            Text(text = "4 / 6",
                                color = Color.White,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp)
                        }
                        Row(modifier = Modifier
                            .padding(top = 25.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Row{
                                Icon(painter = painterResource(R.drawable.coffee_cup1),
                                    contentDescription = null,
                                    tint = Color.Unspecified)
                                Icon(painter = painterResource(R.drawable.coffee_cup1),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .padding(start = 2.dp))
                                Icon(painter = painterResource(R.drawable.coffee_cup1),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .padding(start = 2.dp))
                                Icon(painter = painterResource(R.drawable.coffee_cup1),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .padding(start = 2.dp))
                                Icon(painter = painterResource(R.drawable.coffee_cup1),
                                    contentDescription = null,
                                    tint = colorResource(R.color.grayColor),
                                    modifier = Modifier
                                        .padding(start = 2.dp))
                                Icon(painter = painterResource(R.drawable.coffee_cup1),
                                    contentDescription = null,
                                    tint = colorResource(R.color.grayColor),
                                    modifier = Modifier
                                        .padding(start = 2.dp))
                            }
                            Text(text = "16%",
                                color = colorResource(R.color.mainColor),
                                fontFamily = poppins,
                                fontWeight = FontWeight(500),
                                fontSize = 25.sp
                            )
                        }
                    }
                }
                Box(modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth()
                    .background(
                        color = colorResource(R.color.agree),
                        shape = RoundedCornerShape(12.dp)
                    )) {
                    Icon(painter = painterResource(R.drawable.coffee_beans),
                        contentDescription = null,
                        tint = Color.White.copy(alpha = 0.26f),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                    )
                    Row(modifier = Modifier
                        .padding(top = 25.dp)
                        .padding(start = 30.dp)
                        .padding(end = 20.dp)
                        .padding(bottom = 23.dp)
                        .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Column {
                            Text(text = stringResource(R.string.my_points),
                                color = Color.White,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = dmSans
                            )
                            Text(text = "240",
                                color = Color.White,
                                fontWeight = FontWeight(500),
                                fontSize = 25.sp,
                                fontFamily = poppins,
                                modifier = Modifier
                                    .padding(top = 2.dp)
                            )
                        }
                        Box(modifier = Modifier
                            .background(
                                color = colorResource(R.color.payPoints).copy(alpha = 0.19f),
                                shape = RoundedCornerShape(5.dp)
                            )
                            .size(111.dp, 28.dp),
                            contentAlignment = Alignment.Center){
                            Text(text = stringResource(R.string.pay_points),
                                color = Color.White,
                                fontFamily = poppins,
                                fontWeight = FontWeight(500),
                                fontSize = 10.sp)
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            BottomNavigationBar(navController, Navigation.Reward)
        }
    }
}