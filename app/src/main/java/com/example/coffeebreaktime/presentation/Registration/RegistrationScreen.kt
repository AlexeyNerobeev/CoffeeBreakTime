package com.example.coffeebreaktime.presentation.Registration

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import com.example.coffeebreaktime.presentation.Authorization.AuthorizationEvent
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun RegistrationScreen(navController: NavController, vm: RegistrationVM = hiltViewModel()) {
    val state = vm.state.value
    val tfList = listOf(
        TextFieldData(
            value = state.name,
            onValueChange = {vm.onEvent(RegistrationEvent.EnteredName(it))},
            leadingIcon = R.drawable.profile_icon,
            testTag = "username",
            placeholder = stringResource(R.string.username),
            trailingIcon = false,
            visualTransform = false,
            visualChange = {vm.onEvent(RegistrationEvent.VisualChange)},
            padding = 57
        ),
        TextFieldData(
            value = state.phone,
            onValueChange = {vm.onEvent(RegistrationEvent.EnteredPhone(it))},
            leadingIcon = R.drawable.smartphone_icon,
            testTag = "phone",
            placeholder = stringResource(R.string.phone_number),
            trailingIcon = false,
            visualTransform = false,
            visualChange = {vm.onEvent(RegistrationEvent.VisualChange)},
            padding = 36
        ),
        TextFieldData(
            value = state.email,
            onValueChange = {vm.onEvent(RegistrationEvent.EnteredEmail(it))},
            leadingIcon = R.drawable.profile_icon,
            testTag = "email",
            placeholder = stringResource(R.string.email_address),
            trailingIcon = false,
            visualTransform = false,
            visualChange = {vm.onEvent(RegistrationEvent.VisualChange)},
            padding = 36
        ),
        TextFieldData(
            value = state.password,
            onValueChange = {vm.onEvent(RegistrationEvent.EnteredPassword(it))},
            leadingIcon = R.drawable.lock_icon,
            testTag = "password",
            placeholder = stringResource(R.string.password),
            trailingIcon = true,
            visualTransform = state.visualTransform,
            visualChange = {vm.onEvent(RegistrationEvent.VisualChange)},
            padding = 36
        )
    )
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {  innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Theme.colors.mainBackground)) {
            IconButton(
                onClick = {

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
                .padding(horizontal = 41.dp)) {
                Text(text = stringResource(R.string.sign_up_title),
                    color = Theme.colors.signInText,
                    fontWeight = FontWeight(400),
                    fontSize = 22.sp,
                    fontFamily = roboto)
                Text(text = stringResource(R.string.create_an_account_here),
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
                Row(modifier = Modifier
                    .padding(top = 22.dp),
                    verticalAlignment = Alignment.Top){
                    Checkbox(
                        checked = state.checked,
                        onCheckedChange = {
                            vm.onEvent(RegistrationEvent.Checked)
                        },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = colorResource(R.color.checkbox),
                            checkedColor = Color.Transparent,
                            uncheckedColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .background(
                                color = Color.Transparent,
                                shape = RectangleShape
                            )
                            .border(
                                1.dp,
                                color = colorResource(R.color.checkbox)
                            )
                            .size(17.dp)
                    )
                    Text(text = stringResource(R.string.agree),
                        color = colorResource(R.color.agree),
                        fontWeight = FontWeight(400),
                        fontFamily = roboto,
                        fontSize =  14.sp,
                        modifier = Modifier
                            .padding(start = 8.dp))
                }
                IconButton(
                    onClick = {
                        vm.onEvent(RegistrationEvent.SignUp)
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = colorResource(R.color.mainColor)
                    ),
                    modifier = Modifier
                        .padding(top = 31.dp)
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
            }
        }
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomStart){
            Row(modifier = Modifier
                .padding(bottom = 82.dp)
                .padding(start = 41.dp)) {
                Text(text = stringResource(R.string.already_sign_up),
                    color = colorResource(R.color.grayColor),
                    fontFamily = roboto,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400))
                Text(text = stringResource(R.string.sign_in),
                    color = Theme.colors.bottomSignUp,
                    fontFamily = roboto,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier
                        .clickable{
                            navController.navigate(Navigation.AuthorizationScreen)
                        })

            }
        }
    }
}