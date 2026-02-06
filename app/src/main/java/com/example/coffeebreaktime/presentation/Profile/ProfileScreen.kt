package com.example.coffeebreaktime.presentation.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.common.ProfileRow
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.presentation.Profile.common.ProfileRowData
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun ProfileScreen(navController: NavController, vm: ProfileVM = hiltViewModel()) {
    val state = vm.state.value
    val profileDataList = listOf(
        ProfileRowData(
            icon = R.drawable.profile_icon,
            title = stringResource(R.string.name),
            mainText = state.profile.name,
            padding = 0,
            editIcon = R.drawable.edit_icon
        ),
        ProfileRowData(
            icon = R.drawable.phone_icon,
            title = stringResource(R.string.phone),
            mainText = state.profile.phone,
            padding = 26,
            editIcon = R.drawable.edit_icon
        ),
        ProfileRowData(
            icon = R.drawable.email_icon,
            title = stringResource(R.string.email),
            mainText = state.profile.email,
            padding = 26,
            editIcon = R.drawable.edit_icon
        ),
        ProfileRowData(
            icon = R.drawable.location_icon,
            title = stringResource(R.string.magic_coffee),
            mainText = state.profile.address,
            padding = 26,
            editIcon = R.drawable.edit_icon
        ),
        ProfileRowData(
            icon = R.drawable.qr_icon,
            title = stringResource(R.string.qr_code),
            mainText = stringResource(R.string.to_receive_an_order),
            padding = 26,
            editIcon = R.drawable.more_icon
        )
    )
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)) {
            Box(modifier = Modifier
                .padding(top = 21.dp)
                .fillMaxWidth()){
                IconButton(
                    onClick = {

                    },
                    modifier = Modifier
                        .padding(start = 26.dp)
                ) {
                    Icon(painter = painterResource(R.drawable.arrow_left),
                        contentDescription = null,
                        tint = Theme.colors.backIcon)
                }
                Text(text = stringResource(R.string.profile),
                    color = Theme.colors.oppositeColor,
                    fontFamily = roboto,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    modifier = Modifier
                        .align(Alignment.TopCenter))
            }
            Column(
                modifier = Modifier
                    .padding(top = 29.dp)
                    .padding(horizontal = 33.dp)
                    .fillMaxWidth()
            ) {
                for (item in profileDataList) {
                    ProfileRow(
                        icon = item.icon,
                        title = item.title,
                        mainText = item.mainText,
                        padding = item.padding,
                        editIcon = item.editIcon
                    )
                }
            }
        }
    }
}