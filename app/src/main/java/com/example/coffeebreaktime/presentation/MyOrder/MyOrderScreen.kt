package com.example.coffeebreaktime.presentation.MyOrder

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.coffeebreaktime.common.ErrorAlertDialog
import com.example.coffeebreaktime.common.dmSans
import com.example.coffeebreaktime.common.montserrat
import com.example.coffeebreaktime.common.poppins
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun MyOrderScreen(navController: NavController, vm: MyOrderVM = hiltViewModel()) {
    val state = vm.state.value
    if (state.error) {
        ErrorAlertDialog(error = stringResource(R.string.error)) {
            vm.onEvent(MyOrderEvent.ChangeError)
        }
    }
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
            IconButton(
                onClick = {
                    navController.navigate(Navigation.Menu)
                },
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(start = 26.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.arrow_left),
                    contentDescription = null,
                    tint = Theme.colors.backIcon
                )
            }
            Text(
                text = stringResource(R.string.my_order),
                color = Theme.colors.myOrder,
                fontWeight = FontWeight(500),
                fontFamily = roboto,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 24.dp)
                    .padding(start = 29.dp)
            )
            if (state.load) {
                CircularProgressIndicator(color = Theme.colors.oppositeColor)
            } else {
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 27.dp)
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                ) {
                    items(state.orderList) { item ->
                        Box(
                            modifier = Modifier
                                .padding(bottom = 21.dp)
                                .fillMaxWidth()
                                .background(
                                    color = Theme.colors.myOrderBox,
                                    shape = RoundedCornerShape(15.dp)
                                )
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(top = 18.dp)
                                    .padding(bottom = 9.dp)
                                    .padding(end = 6.dp)
                                    .padding(start = 25.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.Top
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    AsyncImage(
                                        model = item.image,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .width(57.dp),
                                        contentScale = ContentScale.FillWidth
                                    )
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 15.dp)
                                    ) {
                                        Text(
                                            text = item.name,
                                            color = Theme.colors.myOrder,
                                            fontWeight = FontWeight(500),
                                            fontFamily = roboto,
                                            fontSize = 12.sp
                                        )
                                        Text(
                                            text = item.description,
                                            color = Theme.colors.myOrderDescription,
                                            fontWeight = FontWeight(400),
                                            fontFamily = roboto,
                                            fontSize = 10.sp,
                                            modifier = Modifier
                                                .padding(top = 8.dp)
                                        )
                                        Text(
                                            text = "x " + item.count.toString(),
                                            color = Theme.colors.myOrderCurrent,
                                            fontWeight = FontWeight(500),
                                            fontFamily = roboto,
                                            fontSize = 12.sp,
                                            modifier = Modifier
                                                .padding(top = 5.dp)
                                        )
                                    }
                                }
                                Text(
                                    text = item.sum.toString() + " ₽",
                                    color = Theme.colors.myOrder,
                                    fontWeight = FontWeight(600),
                                    fontFamily = montserrat,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                modifier = Modifier
                    .padding(bottom = 33.dp)
                    .padding(start = 33.dp)
                    .padding(end = 28.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.total_suma),
                        color = Theme.colors.myOrderTotal,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = roboto
                    )
                    Text(
                        text = state.total.toString() + " ₽",
                        color = Theme.colors.oppositeColor,
                        fontSize = 25.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = poppins,
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .padding(start = 30.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .background(
                            Theme.colors.myOrderButton,
                            shape = RoundedCornerShape(30.dp)
                        )
                        .width(162.dp)
                        .clickable {
                            vm.onEvent(MyOrderEvent.Pay)
                        }) {
                    Row(
                        modifier = Modifier
                            .padding(start = 29.dp)
                            .padding(end = 41.dp)
                            .padding(vertical = 14.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.cart_icon),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Text(
                            text = stringResource(R.string.next),
                            color = Color.White,
                            fontFamily = poppins,
                            fontWeight = FontWeight(600),
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
        if (state.pay) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f)),
                contentAlignment = Alignment.BottomCenter
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = Theme.colors.payPanel,
                            shape = RoundedCornerShape(
                                topStart = 35.dp,
                                topEnd = 35.dp
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 35.dp)
                            .padding(bottom = 33.dp)
                            .padding(start = 33.dp)
                            .padding(end = 28.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.pay_order),
                            color = Theme.colors.backIcon,
                            fontWeight = FontWeight(400),
                            fontSize = 20.sp,
                            fontFamily = dmSans
                        )
                        Row(
                            modifier = Modifier
                                .padding(top = 79.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Theme.colors.myOrderBox,
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .size(47.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.cart_icon),
                                    contentDescription = null,
                                    tint = Theme.colors.myOrder,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .padding(start = 24.dp)
                            ) {
                                Text(
                                    text = state.name,
                                    color = Theme.colors.myOrder,
                                    fontFamily = roboto,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500)
                                )
                                Text(
                                    text = state.name,
                                    color = Theme.colors.payPanelAddress,
                                    fontFamily = montserrat,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight(400)
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .padding(top = 45.dp)
                                .fillMaxWidth()
                                .background(
                                    color = Theme.colors.myOrderBox,
                                    shape = RoundedCornerShape(12.dp)
                                )
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(start = 21.dp)
                                    .padding(end = 15.dp)
                                    .padding(top = 18.dp)
                                    .padding(bottom = 17.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .border(
                                                width = 1.dp,
                                                shape = CircleShape,
                                                color = Theme.colors.backIcon
                                            )
                                            .size(20.dp)
                                            .clickable {
                                                vm.onEvent(MyOrderEvent.SelectSbp)
                                            },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (state.selectSbp) {
                                            Box(
                                                modifier = Modifier
                                                    .background(
                                                        color = Theme.colors.backIcon,
                                                        shape = CircleShape
                                                    )
                                                    .size(10.dp)
                                            )
                                        }
                                    }
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 18.dp)
                                    ) {
                                        Text(
                                            text = stringResource(R.string.pay_online),
                                            color = Theme.colors.myOrder,
                                            fontWeight = FontWeight(500),
                                            fontFamily = dmSans,
                                            fontSize = 14.sp
                                        )
                                        Text(
                                            text = stringResource(R.string.sbp),
                                            color = Theme.colors.payPanelSbp,
                                            fontSize = 10.sp,
                                            fontFamily = poppins,
                                            fontWeight = FontWeight(500),
                                            modifier = Modifier
                                                .padding(top = 7.dp)
                                        )
                                    }
                                }
                                Image(
                                    painter = painterResource(R.drawable.sbp),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .height(46.dp),
                                    contentScale = ContentScale.FillHeight
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .padding(top = 45.dp)
                                .fillMaxWidth()
                                .background(
                                    color = Theme.colors.myOrderBox,
                                    shape = RoundedCornerShape(12.dp)
                                )
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(start = 21.dp)
                                    .padding(end = 15.dp)
                                    .padding(top = 18.dp)
                                    .padding(bottom = 17.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .border(
                                                width = 1.dp,
                                                shape = CircleShape,
                                                color = Theme.colors.backIcon
                                            )
                                            .size(20.dp)
                                            .clickable {
                                                vm.onEvent(MyOrderEvent.SelectBankCard)
                                            },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (state.selectBankCard) {
                                            Box(
                                                modifier = Modifier
                                                    .background(
                                                        color = Theme.colors.backIcon,
                                                        shape = CircleShape
                                                    )
                                                    .size(10.dp)
                                            )
                                        }
                                    }
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 18.dp)
                                    ) {
                                        Text(
                                            text = stringResource(R.string.bank_card),
                                            color = Theme.colors.myOrder,
                                            fontWeight = FontWeight(500),
                                            fontFamily = dmSans,
                                            fontSize = 14.sp
                                        )
                                        Text(
                                            text = "2540 xxxx xxxx 2648",
                                            color = Theme.colors.payPanelSbp,
                                            fontSize = 10.sp,
                                            fontFamily = poppins,
                                            fontWeight = FontWeight(500),
                                            modifier = Modifier
                                                .padding(top = 7.dp)
                                        )
                                    }
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(R.drawable.mir),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .height(14.dp),
                                        contentScale = ContentScale.FillHeight
                                    )
                                    Image(
                                        painter = painterResource(R.drawable.union_pay),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(start = 7.dp)
                                            .height(26.dp),
                                        contentScale = ContentScale.FillHeight
                                    )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 165.dp)
                                .padding(bottom = 33.dp)
                                .padding(start = 33.dp)
                                .padding(end = 28.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = stringResource(R.string.total_stoimost),
                                    color = Theme.colors.myOrderTotal,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = roboto
                                )
                                Text(
                                    text = state.total.toString() + " ₽",
                                    color = Theme.colors.oppositeColor,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = poppins,
                                    modifier = Modifier
                                        .padding(top = 4.dp)
                                        .padding(start = 30.dp)
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .padding(start = 50.dp)
                                    .background(
                                        Theme.colors.myOrderButton,
                                        shape = RoundedCornerShape(30.dp)
                                    )
                                    .width(162.dp)
                                    .clickable {
                                        navController.navigate(Navigation.OrderIsConfirmed(state.name,
                                            state.address))
                                    }) {
                                Row(
                                    modifier = Modifier
                                        .padding(start = 29.dp)
                                        .padding(end = 41.dp)
                                        .padding(vertical = 14.dp)
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.card_icon),
                                        contentDescription = null,
                                        tint = Color.White
                                    )
                                    Text(
                                        text = stringResource(R.string.paynow),
                                        color = Color.White,
                                        fontFamily = poppins,
                                        fontWeight = FontWeight(600),
                                        fontSize = 14.sp
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