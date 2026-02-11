package com.example.coffeebreaktime.presentation.Designer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
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
import com.example.coffeebreaktime.common.inter
import com.example.coffeebreaktime.common.montserrat
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun DesignerScreen(navController: NavController, vm: DesignerVM = hiltViewModel()) {
    val state = vm.state.value
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
                            navController.navigate(Navigation.AdditivesScreen)
                        })
                Text(text = stringResource(R.string.coffeeman_enciclopedy),
                    modifier = Modifier
                        .padding(top = 14.dp)
                        .clickable {
                            vm.onEvent(DesignerEvent.PanelChange)
                        })
                Button(onClick = {
                    navController.navigate(Navigation.MyOrder)
                },
                    modifier = Modifier
                        .padding(top = 14.dp)) {
                    Text(text = stringResource(R.string.next))
                }
            }
        }
        if(state.panel){
            Box(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        colorResource(R.color.mainColor),
                        shape = RoundedCornerShape(
                            topStart = 25.dp,
                            topEnd = 25.dp
                        )
                    )){
                    Column(modifier = Modifier
                        .padding(top = 21.dp)
                        .padding(bottom = 43.dp)
                        .padding(start = 36.dp)
                        .padding(end = 40.dp)
                        .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = stringResource(R.string.coffeeman_enciclopedy),
                            color = Color.White,
                            fontFamily = inter,
                            fontWeight = FontWeight(400),
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center)
                        Text(text = "Бленд, состоящий из 90% арабики и 10% робусты, считается классическим для итальянского эспрессо. Не советуем создавать бленд с содержанием робусты более 30%.",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = montserrat,
                            modifier = Modifier
                                .padding(top = 30.dp)
                        )
                        Row(modifier = Modifier
                            .padding(top = 29.dp)
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically){
                            Text(text = stringResource(R.string.skip),
                                color = Color.White,
                                fontWeight = FontWeight(500),
                                fontFamily = roboto,
                                fontSize = 18.sp)
                            Row {
                               Box(modifier = Modifier
                                   .background(color = Color.White,
                                       shape = CircleShape
                                   )
                                   .size(8.dp))
                                Box(modifier = Modifier
                                    .padding(start = 8.dp)
                                    .background(color = Color.White.copy(alpha = 0.3f),
                                        shape = CircleShape
                                    )
                                    .size(8.dp))
                                Box(modifier = Modifier
                                    .padding(start = 8.dp)
                                    .background(color = Color.White.copy(alpha = 0.3f),
                                        shape = CircleShape
                                    )
                                    .size(8.dp))
                            }
                            Text(text = stringResource(R.string.next),
                                color = Color.White,
                                fontWeight = FontWeight(500),
                                fontFamily = roboto,
                                fontSize = 18.sp)
                        }
                    }
                }
            }
        }
    }
}