package com.example.coffeebreaktime.presentation.ResetPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coffeebreaktime.Navigation
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.common.ErrorAlertDialog
import com.example.coffeebreaktime.common.ModifiedTextField
import com.example.coffeebreaktime.common.roboto
import com.example.coffeebreaktime.presentation.ForgotPassword.ForgotPasswordEvent
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun ResetPasswordScreen(navController: NavController, vm: ResetPasswordVM = hiltViewModel()) {
    val state = vm.state.value
    if (state.isComplete){
        navController.navigate(Navigation.Menu)
    }
    if(state.error){
        ErrorAlertDialog(error = stringResource(R.string.invalid_password)) {
            vm.onEvent(ResetPasswordEvent.ErrorChange)
        }
    }
    Scaffold(modifier = Modifier
        .fillMaxSize()){
            innerPadding ->
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
                Text(text = stringResource(R.string.forgot_password),
                    color = Theme.colors.signInText,
                    fontFamily = roboto,
                    fontWeight = FontWeight(400),
                    fontSize = 22.sp
                )
                Text(
                    text = stringResource(R.string.enter_email),
                    color = Theme.colors.welcomeText,
                    fontFamily = roboto,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 24.dp)
                )
                ModifiedTextField(
                    value = state.password,
                    onValueChange = {vm.onEvent(ResetPasswordEvent.EnteredPassword(it))},
                    leadingIcon = R.drawable.lock_icon,
                    testTag = "password",
                    placeholder = stringResource(R.string.password),
                    trailingIcon = true,
                    visualTransform = state.visualTransform,
                    visualChange = {vm.onEvent(ResetPasswordEvent.VisualChange)},
                    padding = 46
                )
                IconButton(
                    onClick = {
                        vm.onEvent(ResetPasswordEvent.PasswordChange)
                    },
                    modifier = Modifier
                        .padding(top = 165.dp)
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