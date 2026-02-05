package com.example.coffeebreaktime.presentation.Menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.ui.theme.Theme

@Composable
fun MenuScreen(navController: NavController) {
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)) {
            Box(modifier = Modifier
                .fillMaxSize()){
                Image(painter = painterResource(R.drawable.map),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxSize())
                Box(modifier = Modifier
                    .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter){
                    Column(modifier = Modifier
                        .fillMaxWidth()) {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(painter = painterResource(R.drawable.target),
                                contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}