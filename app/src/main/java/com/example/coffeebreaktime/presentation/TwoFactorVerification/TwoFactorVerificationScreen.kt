package com.example.coffeebreaktime.presentation.TwoFactorVerification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.coffeebreaktime.common.ErrorAlertDialog
import com.example.coffeebreaktime.common.VerificationTextField
import com.example.coffeebreaktime.common.VerificationTfData
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.presentation.ForgotPassword.ForgotPasswordEvent
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun TwoFactorVerificationScreen(navController: NavController, vm: TwoFactorVerificationVM = hiltViewModel()) {
    val state = vm.state.value
    if(state.next){
        navController.navigate(Navigation.ResetPassword)
    }
    if(state.error){
        ErrorAlertDialog(error = stringResource(R.string.all_fields_must_be_filled_in)) {
            vm.onEvent(TwoFactorVerificationEvent.ChangeError)
        }
    }
    val tfList = listOf(
        VerificationTfData(
            value = state.firstNum,
            onValueChange = {vm.onEvent(TwoFactorVerificationEvent.EnteredFirstNum(it))},
            padding = 0
        ),
        VerificationTfData(
            value = state.secondNum,
            onValueChange = {vm.onEvent(TwoFactorVerificationEvent.EnteredSecondNum(it))},
            padding = 22
        ),
        VerificationTfData(
            value = state.thirdNum,
            onValueChange = {vm.onEvent(TwoFactorVerificationEvent.EnteredThirdNum(it))},
            padding = 22
        ),
        VerificationTfData(
            value = state.fourthNum,
            onValueChange = {vm.onEvent(TwoFactorVerificationEvent.EnteredFourthNum(it))},
            padding = 22
        )
    )
    Scaffold(modifier = Modifier
    .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(start = 26.dp)
            ) {
                Icon(painter = painterResource(R.drawable.arrow_left),
                    contentDescription = null,
                    tint = Theme.colors.backIcon)
            }
            Column(modifier = Modifier
                .padding(top = 46.dp)
                .padding(horizontal = 41.dp)
                .fillMaxWidth()) {
                Text(text = stringResource(R.string.check),
                    color = Theme.colors.signInText,
                    fontFamily = roboto,
                    fontWeight = FontWeight(400),
                    fontSize = 22.sp
                )
                Text(
                    text = stringResource(R.string.enter_code),
                    color = Theme.colors.welcomeText,
                    fontFamily = roboto,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 24.dp)
                )
                Row(modifier = Modifier
                    .padding(top = 38.dp)
                    .align(Alignment.CenterHorizontally)) {
                    for(item in tfList){
                        VerificationTextField(
                            value = item.value,
                            onValueChange = item.onValueChange,
                            padding = item.padding
                        )
                    }
                }
                Row(modifier = Modifier
                    .padding(top = 46.dp)
                    .align(Alignment.CenterHorizontally)) {
                    Text(text = stringResource(R.string.retry),
                        color = Theme.colors.retry,
                        fontWeight = FontWeight(400),
                        fontFamily = roboto,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center)
                    Text(text = state.seconds.toString(),
                        color = Theme.colors.retry,
                        fontWeight = FontWeight(400),
                        fontFamily = roboto,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center)
                }
                IconButton(
                    onClick = {
                        vm.onEvent(TwoFactorVerificationEvent.GoNext)
                    },
                    modifier = Modifier
                        .padding(top = 153.dp)
                        .align(Alignment.End)
                        .clip(CircleShape)
                        .background(
                            color = colorResource(R.color.mainColor),
                            shape = CircleShape
                        )
                        .size(64.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = colorResource(R.color.mainColor)
                    )
                ) {
                    Icon(painter = painterResource(R.drawable.arrow_right),
                        contentDescription = null,
                        tint = Theme.colors.mainBackground)
                }
            }
        }
    }
}