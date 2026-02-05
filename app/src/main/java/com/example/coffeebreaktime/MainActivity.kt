package com.example.coffeebreaktime

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeebreaktime.presentation.Authorization.AuthorizationScreen
import com.example.coffeebreaktime.presentation.Cafe.CafeScreen
import com.example.coffeebreaktime.presentation.ForgotPassword.ForgotPasswordScreen
import com.example.coffeebreaktime.presentation.Menu.MenuScreen
import com.example.coffeebreaktime.presentation.Registration.RegistrationScreen
import com.example.coffeebreaktime.presentation.ResetPassword.ResetPasswordScreen
import com.example.coffeebreaktime.presentation.StartUp.StartUpScreen
import com.example.coffeebreaktime.presentation.TwoFactorVerification.TwoFactorVerificationScreen
import com.example.coffeebreaktime.presentation.Welcome.WelcomeScreen
import com.example.coffeebreaktime.ui.theme.AppTheme
import com.example.coffeebreaktime.ui.theme.CoffeeBreakTimeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController,
                    startDestination = Navigation.WelcomeScreen,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    composable<Navigation.WelcomeScreen> {
                        WelcomeScreen(navController)
                    }
                    composable<Navigation.AuthorizationScreen> {
                        AuthorizationScreen(navController)
                    }
                    composable<Navigation.RegistrationScreen> {
                        RegistrationScreen(navController)
                    }
                    composable<Navigation.StartUpScreen> {
                        StartUpScreen(navController)
                    }
                    composable<Navigation.ForgotPassword> {
                        ForgotPasswordScreen(navController)
                    }
                    composable<Navigation.TwoFactorVerification> {
                        TwoFactorVerificationScreen(navController)
                    }
                    composable<Navigation.ResetPassword> {
                        ResetPasswordScreen(navController)
                    }
                    composable<Navigation.Menu> {
                        MenuScreen(navController)
                    }
                    composable<Navigation.CafeScreen> {
                        CafeScreen(navController)
                    }
                }
            }
        }
    }
}