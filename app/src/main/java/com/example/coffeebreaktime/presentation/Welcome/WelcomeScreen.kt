package com.example.coffeebreaktime.presentation.Welcome

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coffeebreaktime.Navigation
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.common.dmSans
import com.example.coffeebreaktime.common.poppins
import com.example.coffeebreaktime.common.redressed
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun WelcomeScreen(navController: NavController, vm: WelcomeVM = hiltViewModel()) {
    val state = vm.state.value
    if(state.next){
        navController.navigate(Navigation.AuthorizationScreen)
    }
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Theme.colors.mainBackground)) {
            Box(modifier = Modifier
                .padding(top = 62.dp)
                .fillMaxWidth()
                .background(color = colorResource(R.color.mainColor))){
                Column(modifier = Modifier
                    .padding(top = 63.dp)
                    .padding(bottom = 46.dp)
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.coffee_cup_icon),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(top = 63.dp)
                            .size(98.dp)
                    )
                    Text(text = stringResource(R.string.coffee_break),
                        color = Color.White,
                        fontWeight = FontWeight(400),
                        fontFamily = redressed,
                        fontSize = 64.sp,
                        modifier = Modifier
                            .padding(top = 54.dp)
                    )
                }
            }
            Text(text = stringResource(R.string.feel_like_barista),
                color = Theme.colors.oppositeColor,
                fontSize = 25.sp,
                fontWeight = FontWeight(500),
                fontFamily = poppins,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 25.dp)
            )
            Text(text = stringResource(R.string.any_coffee),
                color = colorResource(R.color.grayColor),
                fontSize = 17.sp,
                fontWeight = FontWeight(400),
                fontFamily = dmSans,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 5.dp)
            )
            Row(modifier = Modifier
                .padding(top = 51.dp)
                .align(Alignment.CenterHorizontally)) {
                Box(modifier = Modifier
                    .background(color = colorResource(R.color.mainColor),
                        shape = RoundedCornerShape(50.dp))
                    .size(33.dp, 10.dp))
                Box(modifier = Modifier
                    .padding(start = 10.dp)
                    .background(color = Theme.colors.circleShape,
                        shape = RoundedCornerShape(50.dp))
                    .size(10.dp))
                Box(modifier = Modifier
                    .padding(start = 10.dp)
                    .background(color = Theme.colors.circleShape,
                        shape = RoundedCornerShape(50.dp))
                    .size(10.dp)
                )
            }
        }
    }
}