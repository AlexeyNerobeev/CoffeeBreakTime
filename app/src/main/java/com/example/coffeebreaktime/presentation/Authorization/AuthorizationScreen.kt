package com.example.coffeebreaktime.presentation.Authorization

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.example.coffeebreaktime.common.ModifiedTextField
import com.example.coffeebreaktime.common.TextFieldData
import com.example.coffeebreaktime.common.poppins
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun AuthorizationScreen(navController: NavController, vm: AuthorizationVM = hiltViewModel()) {
    val state = vm.state.value
    val tfList = listOf(
        TextFieldData(
            value = state.email,
            onValueChange = {vm.onEvent(AuthorizationEvent.EnteredEmail(it))},
            leadingIcon = R.drawable.email_icon,
            testTag = "email",
            placeholder = stringResource(R.string.email_address),
            trailingIcon = false,
            visualTransform = state.visualTransform,
            visualChange = {vm.onEvent(AuthorizationEvent.VisualChange)},
            padding = 57
        ),
        TextFieldData(
            value = state.password,
            onValueChange = {vm.onEvent(AuthorizationEvent.EnteredPassword(it))},
            leadingIcon = R.drawable.lock_icon,
            testTag = "password",
            placeholder = stringResource(R.string.password),
            trailingIcon = true,
            visualTransform = state.visualTransform,
            visualChange = {vm.onEvent(AuthorizationEvent.VisualChange)},
            padding = 36
        )
    )
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Theme.colors.mainBackground)) {
            Column(modifier = Modifier
                .padding(top = 91.dp)
                .padding(horizontal = 41.dp)) {
                Text(text = stringResource(R.string.sing_in),
                    color = Theme.colors.signInText,
                    fontWeight = FontWeight(400),
                    fontSize = 22.sp,
                    fontFamily = roboto)
                Text(text = stringResource(R.string.welcome),
                    color = Theme.colors.welcomeText,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,
                    fontFamily = roboto,
                    modifier = Modifier
                        .padding(top = 24.dp))
                for(item in tfList){
                    ModifiedTextField(
                        item.value,
                        item.onValueChange,
                        item.leadingIcon,
                        item.testTag,
                        item.placeholder,
                        item.trailingIcon,
                        item.visualTransform,
                        item.visualChange,
                        item.padding
                    )
                }
                Text(text = stringResource(R.string.forgot_password),
                    color = Theme.colors.forgotPassword,
                    fontSize = 14.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight(500),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 27.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable {

                        }
                )
            }
        }
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            Column(modifier = Modifier
                .padding(bottom = 82.dp)
                .padding(start = 41.dp)
                .padding(end = 47.dp)
                .fillMaxWidth()) {
                IconButton(
                    onClick = {
                        vm.onEvent(AuthorizationEvent.SignIn)
                        navController.navigate(Navigation.StartUpScreen)
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = colorResource(R.color.mainColor)
                    ),
                    modifier = Modifier
                        .align(Alignment.End)
                        .clip(CircleShape)
                        .background(
                            color = colorResource(R.color.mainColor),
                            shape = CircleShape
                        )
                        .size(64.dp)
                ) {
                    Icon(painter = painterResource(R.drawable.arrow_right),
                        tint = Theme.colors.mainBackground,
                        contentDescription = null)
                }
                Text(text = stringResource(R.string.sign_in_with),
                    color = Theme.colors.oppositeColor,
                    fontWeight = FontWeight(400),
                    fontFamily = roboto,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 21.dp)
                        .align(Alignment.CenterHorizontally))
                Row(modifier = Modifier
                    .padding(top = 14.dp)
                    .align(Alignment.CenterHorizontally)) {
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(38.dp)
                    ) {
                        Icon(painter = painterResource(R.drawable.yandex),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clip(CircleShape)
                            .size(38.dp)
                    ) {
                        Icon(painter = painterResource(R.drawable.google),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clip(CircleShape)
                            .size(38.dp)
                    ) {
                        Icon(painter = painterResource(R.drawable.vk),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                }
                Row(modifier = Modifier
                    .padding(top = 36.dp)) {
                    Text(text = stringResource(R.string.first_time),
                        color = colorResource(R.color.grayColor),
                        fontFamily = roboto,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400))
                    Text(text = stringResource(R.string.sign_up),
                        color = Theme.colors.bottomSignUp,
                        fontFamily = roboto,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        modifier = Modifier
                            .clickable{
                                navController.navigate(Navigation.RegistrationScreen)
                            })
                }
            }
        }
    }
}