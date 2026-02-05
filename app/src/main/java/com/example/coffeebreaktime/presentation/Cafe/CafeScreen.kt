package com.example.coffeebreaktime.presentation.Cafe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.common.ChooseCoffeeShopButtons
import com.example.coffeebreaktime.common.ChooseShopData
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun CafeScreen(navController: NavController) {
    val buttonsList = listOf(
        ChooseShopData(
            text = "ул. Туркестанская, 3",
            padding = 0
        ),
        ChooseShopData(
            text = "ул. Чкалова, 32 ",
            padding = 7
        ),
        ChooseShopData(
            text = "ул. Советская, 3 ",
            padding = 7
        )
    )
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding  ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            Box(modifier = Modifier
                .fillMaxSize()){
                Image(painter = painterResource(R.drawable.map),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillHeight)
                Box(modifier = Modifier
                    .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter){
                    Column(modifier = Modifier
                        .fillMaxWidth()) {
                        IconButton(
                            onClick = {

                            },
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(end = 30.dp)
                        ) {
                            Icon(painter = painterResource(R.drawable.target),
                                contentDescription = null,
                                tint = Color.Unspecified)
                        }
                        Box(modifier = Modifier
                            .padding(top = 35.dp)
                            .fillMaxWidth()
                            .background(
                                color = colorResource(R.color.mainColor),
                                shape = RoundedCornerShape(
                                    topStart = 25.dp,
                                    topEnd = 25.dp
                                )
                            )){
                            Column(modifier = Modifier
                                .padding(top = 27.dp)
                                .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(text = stringResource(R.string.choose_coffeee_shop),
                                    color = Color.White,
                                    fontFamily = roboto,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp
                                )
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 31.dp)
                                    .background(color = Theme.colors.chooseCoffeeShop,
                                        shape = RoundedCornerShape(topStart = 25.dp,
                                            topEnd = 25.dp)),
                                    contentAlignment = Alignment.Center){
                                    Column(modifier = Modifier
                                        .padding(vertical = 21.dp)
                                        .padding(horizontal = 30.dp)
                                        .fillMaxWidth()) {
                                        for(item in buttonsList){
                                            ChooseCoffeeShopButtons(
                                                text = item.text,
                                                padding = item.padding,
                                                navController = navController
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}