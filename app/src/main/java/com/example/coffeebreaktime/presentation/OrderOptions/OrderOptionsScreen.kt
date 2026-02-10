package com.example.coffeebreaktime.presentation.OrderOptions

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
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
import com.example.coffeebreaktime.common.dmSans
import com.example.coffeebreaktime.common.montserrat
import com.example.coffeebreaktime.common.poppins
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.ui.theme.Theme
import io.github.jan.supabase.realtime.Column
import org.jetbrains.annotations.Async

@Composable
fun OrderOptionsScreen(navController: NavController, vm: OrderOptionsVM = hiltViewModel()) {
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
                        text = stringResource(R.string.order),
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
                Box(
                    modifier = Modifier
                        .padding(top = 19.dp)
                        .fillMaxWidth()
                        .background(
                            color = Theme.colors.orderOptionsBox,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = "https://fftixgiacmrjokcjqvoe.supabase.co/storage/v1/object/public/coffee/capuccino.png",
                        contentDescription = null,
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .size(152.dp, 121.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(vertical = 13.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.capuccino),
                        color = Theme.colors.orderOptionsText,
                        fontWeight = FontWeight(500),
                        fontFamily = dmSans,
                        fontSize = 14.sp
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .border(
                                1.dp, color = colorResource(R.color.bottomIcon),
                                shape = RoundedCornerShape(50.dp)
                            )
                            .size(73.dp, 29.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                                .padding(vertical = 4.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "-",
                                color = Theme.colors.orderOptionsText,
                                fontSize = 14.sp,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .clickable {
                                        vm.onEvent(OrderOptionsEvent.MinusCount)
                                    }
                            )
                            Text(
                                text = state.count.toString(),
                                color = Theme.colors.orderOptionsText,
                                fontSize = 14.sp,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(500)
                            )
                            Text(
                                text = "+",
                                color = Theme.colors.orderOptionsText,
                                fontSize = 14.sp,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .clickable {
                                        vm.onEvent(OrderOptionsEvent.PlusCount)
                                    }
                            )
                        }
                    }
                }
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                ) {
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = Color(0xFFF4F5F7)
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(vertical = 17.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.ristretto),
                        color = Theme.colors.orderOptionsText,
                        fontWeight = FontWeight(500),
                        fontFamily = dmSans,
                        fontSize = 14.sp
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(50.dp))
                                .border(
                                    1.dp, color = colorResource(R.color.bottomIcon),
                                    shape = RoundedCornerShape(50.dp)
                                )
                                .size(73.dp, 29.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = stringResource(R.string.one),
                                color = Theme.colors.orderOptionsText,
                                fontWeight = FontWeight(400),
                                fontFamily = dmSans,
                                fontSize = 12.sp
                            )
                        }
                        Box(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .clip(RoundedCornerShape(50.dp))
                                .border(
                                    1.dp, color = colorResource(R.color.bottomIcon),
                                    shape = RoundedCornerShape(50.dp)
                                )
                                .size(73.dp, 29.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = stringResource(R.string.two),
                                color = Theme.colors.orderOptionsText,
                                fontWeight = FontWeight(400),
                                fontFamily = dmSans,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                ) {
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = Color(0xFFF4F5F7)
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(top = 11.dp)
                        .padding(bottom = 17.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.na_meste_na_vinos),
                        color = Theme.colors.orderOptionsText,
                        fontWeight = FontWeight(500),
                        fontFamily = dmSans,
                        fontSize = 14.sp
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.coffee_cup_orderoptions),
                                contentDescription = null,
                                tint = colorResource(R.color.bottomIcon)
                            )
                        }
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.plastic_glass),
                                contentDescription = null,
                                tint = Theme.colors.backIcon
                            )
                        }
                    }
                }
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                ) {
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = Color(0xFFF4F5F7)
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(top = 11.dp)
                        .padding(bottom = 17.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.volume),
                        color = Theme.colors.orderOptionsText,
                        fontWeight = FontWeight(500),
                        fontFamily = dmSans,
                        fontSize = 14.sp
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(
                                onClick = {

                                }
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.volume_icon),
                                    contentDescription = null,
                                    tint = colorResource(R.color.bottomIcon),
                                    modifier = Modifier.size(17.dp, 22.dp)
                                )
                            }
                            Text(text = "250",
                                color = colorResource(R.color.bottomIcon),
                                fontFamily = dmSans,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(start = 22.dp)) {
                            IconButton(
                                onClick = {

                                }
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.volume_icon),
                                    contentDescription = null,
                                    tint = Theme.colors.backIcon,
                                    modifier = Modifier
                                        .size(24.dp, 31.dp)
                                )
                            }
                            Text(text = "350",
                                color = Theme.colors.backIcon,
                                fontFamily = dmSans,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(start = 22.dp)) {
                            IconButton(
                                onClick = {

                                }
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.volume_icon),
                                    contentDescription = null,
                                    tint = colorResource(R.color.bottomIcon),
                                    modifier = Modifier
                                        .size(29.dp, 38.dp)
                                )
                            }
                            Text(text = "450",
                                color = colorResource(R.color.bottomIcon),
                                fontFamily = dmSans,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                        }
                    }
                }
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                ) {
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = Color(0xFFF4F5F7)
                    )
                }
                Row(modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top){
                    Text(text = stringResource(R.string.prepare_to_time),
                        color = Theme.colors.orderOptionsText,
                        fontWeight = FontWeight(500),
                        fontSize = 14.sp,
                        fontFamily = dmSans)
                    Column(horizontalAlignment = Alignment.End) {
                        Switch(
                            checked = state.switch,
                            onCheckedChange = {
                                vm.onEvent(OrderOptionsEvent.SwitchChange)
                            },
                            colors = SwitchDefaults.colors(
                                checkedBorderColor = colorResource(R.color.mainColor),
                                uncheckedBorderColor = colorResource(R.color.grayColor),
                                checkedTrackColor = colorResource(R.color.mainColor),
                                uncheckedTrackColor = colorResource(R.color.grayColor),
                                checkedThumbColor = Color.White,
                                uncheckedThumbColor = Color.White
                            ),
                            modifier = Modifier
                                .size(51.dp,
                                    31.dp)
                        )
                        Box(modifier = Modifier
                            .padding(top = 16.dp)
                            .background(
                                color = Theme.colors.timeBox,
                                shape = RoundedCornerShape(6.dp)
                            )){
                            Text(text = "18 : 10",
                                color = Theme.colors.oppositeColor,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(400),
                                fontSize = 22.sp,
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .padding(vertical = 4.dp)
                            )
                        }
                    }
                }
                Box(modifier = Modifier
                    .padding(top = 16.dp)
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(colorResource(R.color.mainColor),
                        shape = RoundedCornerShape(16.dp))
                    .clickable {
                        navController.navigate(Navigation.Designer)
                    }){
                    Row(modifier = Modifier
                        .padding(vertical = 13.dp)
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween){
                        Row(verticalAlignment = Alignment.CenterVertically){
                            Icon(painter = painterResource(R.drawable.filter_icon),
                                contentDescription = null,
                                tint = Color.White)
                            Text(text = stringResource(R.string.constructor_coffeeman),
                                color = Color.White,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                fontFamily = roboto,
                                modifier = Modifier
                                    .padding(start = 10.dp))
                        }
                        Icon(painter = painterResource(R.drawable.more_icon),
                            contentDescription = null,
                            tint = Color.White)
                    }
                }
                Row(modifier = Modifier
                    .padding(top = 28.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = stringResource(R.string.total_sum),
                        color = Theme.colors.orderOptionsText,
                        fontFamily = roboto,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500))
                    Text(text = "250₽",
                        color = Theme.colors.totalSumColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = montserrat
                    )
                }
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                        .height(46.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = colorResource(R.color.agree),
                            shape = RoundedCornerShape(30.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.agree)
                    )
                ) {
                    Text(text = stringResource(R.string.next),
                        color = Color.White,
                        fontWeight = FontWeight(600),
                        fontSize = 14.sp,
                        fontFamily = poppins)
                }
            }
        }
    }
}
