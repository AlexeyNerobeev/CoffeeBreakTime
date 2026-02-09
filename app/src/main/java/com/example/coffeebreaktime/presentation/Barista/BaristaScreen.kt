package com.example.coffeebreaktime.presentation.Barista

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.coffeebreaktime.Navigation
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.common.BottomNavigationBar
import com.example.coffeebreaktime.common.poppins
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun BaristaScreen(navController: NavController, vm: BaristaVM = hiltViewModel()) {
    val state = vm.state.value
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
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
                        text = stringResource(R.string.order_constructor),
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
                Text(
                    text = stringResource(R.string.choose_barista),
                    color = Theme.colors.backIcon,
                    fontFamily = roboto,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 9.dp)
                )
                if(state.load){
                    CircularProgressIndicator(color = Theme.colors.oppositeColor)
                } else {
                    LazyColumn {
                        items(state.baristaList) { item ->
                            Box(
                                modifier = Modifier
                                    .padding(bottom = 20.dp)
                                    .background(
                                        Theme.colors.baristaBox,
                                        shape = RoundedCornerShape(22.dp)
                                    )
                                    .shadow(elevation = 26.dp, shape = RoundedCornerShape(22.dp))
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(start = 8.dp)
                                        .padding(end = 34.dp)
                                        .padding(vertical = 10.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        AsyncImage(
                                            model = item.image,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(62.dp)
                                                .clip(RoundedCornerShape(16.dp)),
                                            contentScale = ContentScale.Crop
                                        )
                                        Column(
                                            modifier = Modifier
                                                .padding(start = 18.dp)
                                        ) {
                                            Text(
                                                text = item.name,
                                                color = Theme.colors.oppositeColor,
                                                fontWeight = FontWeight(400),
                                                fontFamily = roboto,
                                                fontSize = 14.sp
                                            )
                                            Text(
                                                text = item.status,
                                                color = colorResource(R.color.baristaStatus),
                                                fontSize = 12.sp,
                                                fontFamily = poppins,
                                                fontWeight = FontWeight(400),
                                                modifier = Modifier
                                                    .padding(top = 12.dp)
                                            )
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .background(
                                                color = if (item.status == "Топ-бариста")
                                                    colorResource(R.color.mainColor)
                                                else
                                                    colorResource(R.color.red),
                                                shape = CircleShape
                                            )
                                            .size(15.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            BottomNavigationBar(navController, Navigation.Menu)
        }
    }
}