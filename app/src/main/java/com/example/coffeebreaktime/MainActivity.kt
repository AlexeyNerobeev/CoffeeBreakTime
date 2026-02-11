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
import androidx.navigation.toRoute
import com.example.coffeebreaktime.presentation.Additives.AdditivesScreen
import com.example.coffeebreaktime.presentation.Authorization.AuthorizationScreen
import com.example.coffeebreaktime.presentation.Barista.BaristaScreen
import com.example.coffeebreaktime.presentation.Cafe.CafeScreen
import com.example.coffeebreaktime.presentation.CoffeeCountry.CoffeeCountryScreen
import com.example.coffeebreaktime.presentation.CoffeeType.CoffeeTypeScreen
import com.example.coffeebreaktime.presentation.Designer.DesignerScreen
import com.example.coffeebreaktime.presentation.ForgotPassword.ForgotPasswordScreen
import com.example.coffeebreaktime.presentation.Menu.MenuScreen
import com.example.coffeebreaktime.presentation.MyOrder.MyOrderScreen
import com.example.coffeebreaktime.presentation.MyOrderCurrent.MyOrderCurrentScreen
import com.example.coffeebreaktime.presentation.MyOrderHistory.MyOrderHistoryScreen
import com.example.coffeebreaktime.presentation.OrderIsConfirmed.OrderIsConfirmedScreen
import com.example.coffeebreaktime.presentation.OrderOptions.OrderOptionsScreen
import com.example.coffeebreaktime.presentation.Profile.ProfileScreen
import com.example.coffeebreaktime.presentation.Registration.RegistrationScreen
import com.example.coffeebreaktime.presentation.ResetPassword.ResetPasswordScreen
import com.example.coffeebreaktime.presentation.Reward.RewardScreen
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
                    composable<Navigation.Profile> {
                        ProfileScreen(navController)
                    }
                    composable<Navigation.MyOrderCurrent> {
                        MyOrderCurrentScreen(navController)
                    }
                    composable<Navigation.Reward> {
                        RewardScreen(navController)
                    }
                    composable<Navigation.OrderOptions> {
                        OrderOptionsScreen(navController)
                    }
                    composable<Navigation.Barista> {
                        BaristaScreen(navController)
                    }
                    composable<Navigation.Designer> {
                        DesignerScreen(navController)
                    }
                    composable<Navigation.Country> {
                        CoffeeCountryScreen(navController)
                    }
                    composable<Navigation.CoffeeTypeScreen> {
                        CoffeeTypeScreen(navController)
                    }
                    composable<Navigation.AdditivesScreen> {
                        AdditivesScreen(navController)
                    }
                    composable<Navigation.MyOrder> {
                        MyOrderScreen(navController)
                    }
                    composable<Navigation.OrderIsConfirmed> { backStackEntry ->
                        val route = backStackEntry.toRoute<Navigation.OrderIsConfirmed>()
                        OrderIsConfirmedScreen(navController, name = route.name, address = route.address)
                    }
                    composable<Navigation.MyOrderHistory> {
                        MyOrderHistoryScreen(navController)
                    }
                }
            }
        }
    }
}