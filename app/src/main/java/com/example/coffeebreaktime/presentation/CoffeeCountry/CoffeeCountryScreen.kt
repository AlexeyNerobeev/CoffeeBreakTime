package com.example.coffeebreaktime.presentation.CoffeeCountry

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.common.dmSans
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun CoffeeCountryScreen(navController: NavController, vm: CoffeeCountyVM = hiltViewModel()) {
    val state = vm.state.value
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)) {
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
                Text(text = stringResource(R.string.choose_country),
                    color = Theme.colors.backIcon,
                    fontFamily = roboto,
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 24.dp)
                )
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier
                        .padding(top = 21.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalItemSpacing = 28.dp
                ) {
                    items(state.countryLis){ item ->
                        Column {
                            AsyncImage(
                                model = item.image,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(158.dp)
                                    .clip(RoundedCornerShape(20.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Text(text = item.name,
                                color = Theme.colors.oppositeColor,
                                fontWeight = FontWeight(400),
                                fontSize = 17.sp,
                                fontFamily = dmSans,
                                modifier = Modifier
                                    .padding(top = 7.dp))
                            Text(text = item.description,
                                color = Theme.colors.countryDescription,
                                fontWeight = FontWeight(400),
                                fontSize = 10.sp,
                                fontFamily = dmSans,
                                modifier = Modifier
                                    .padding(top = 7.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}