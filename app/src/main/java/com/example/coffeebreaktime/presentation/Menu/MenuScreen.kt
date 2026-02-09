package com.example.coffeebreaktime.presentation.Menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
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
import com.example.coffeebreaktime.common.BottomNavigationBar
import com.example.coffeebreaktime.common.dmSans
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun MenuScreen(navController: NavController, vm: MenuVM = hiltViewModel()) {
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
            Row(
                modifier = Modifier
                    .padding(top = 27.dp)
                    .padding(start = 26.dp)
                    .padding(end = 33.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.welcome),
                        color = Theme.colors.menuWelcome,
                        fontWeight = FontWeight(600),
                        fontFamily = roboto,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Алексей",
                        color = Theme.colors.menuName,
                        fontWeight = FontWeight(500),
                        fontFamily = roboto,
                        fontSize = 18.sp
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.cart_icon),
                            contentDescription = null,
                            tint = Theme.colors.backIcon
                        )
                    }
                    Icon(
                        painter = painterResource(R.drawable.profile_icon),
                        contentDescription = null,
                        tint = Theme.colors.backIcon,
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .size(26.dp)
                            .clickable{
                                navController.navigate(Navigation.Profile)
                            }
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(top = 7.dp)
                    .fillMaxSize()
                    .background(
                        Theme.colors.menuBoxBackground,
                        shape = RoundedCornerShape(
                            topStart = 25.dp,
                            topEnd = 25.dp
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 25.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.choose_your_coffee),
                        color = Color.White,
                        fontFamily = roboto,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp
                    )
                    if (state.load) {
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 29.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    } else {
                        LazyVerticalStaggeredGrid(
                            columns = StaggeredGridCells.Fixed(2),
                            modifier = Modifier
                                .padding(top = 29.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            verticalItemSpacing = 17.dp
                        ) {
                            items(state.coffeeList) { item ->
                                Box(
                                    modifier = Modifier
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(15.dp)
                                        )
                                        .clickable{
                                            navController.navigate(Navigation.OrderOptions)
                                        }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .padding(top = 25.dp)
                                            .padding(bottom = 7.dp)
                                            .fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier
                                            .padding(horizontal = 26.dp)
                                            .align(Alignment.CenterHorizontally)) {
                                            AsyncImage(
                                                model = item.image,
                                                contentDescription = null,
                                                contentScale = ContentScale.Fit,
                                                modifier = Modifier
                                                    .height(85.dp)
                                                    .align(Alignment.CenterHorizontally)
                                            )
                                            Text(
                                                text = item.name,
                                                color = Color.Black,
                                                fontWeight = FontWeight(500),
                                                fontSize = 14.sp,
                                                fontFamily = dmSans,
                                                modifier = Modifier
                                                    .align(Alignment.CenterHorizontally)
                                                    .padding(top = 12.dp)
                                            )
                                        }
                                        Text(
                                            text = item.price.toString() + "₽",
                                            color = Color.Black,
                                            fontWeight = FontWeight(500),
                                            fontSize = 14.sp,
                                            fontFamily = dmSans,
                                            modifier = Modifier
                                                .padding(top = 2.dp)
                                                .padding(end = 7.dp)
                                                .align(Alignment.End)
                                        )
                                    }
                                }
                            }
                            item {
                                Spacer(
                                    modifier = Modifier
                                        .height(100.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter) {
            BottomNavigationBar(
                navController,
                Navigation.Menu
            )
        }
    }
}