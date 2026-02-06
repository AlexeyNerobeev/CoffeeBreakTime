package com.example.coffeebreaktime.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeebreaktime.R
import com.example.coffeebreaktime.ui.theme.Theme
import kotlinx.datetime.format.Padding

@Composable
fun ProfileRow(
    icon: Int,
    title: String,
    mainText: String,
    padding: Int,
    editIcon: Int
) {
    Row(modifier = Modifier
        .padding(top = padding.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(color = Theme.colors.profileIconsBackground)
                .size(42.dp),
                contentAlignment = Alignment.Center){
                Icon(painter = painterResource(icon),
                    contentDescription = null,
                    tint = Theme.colors.backIcon)
            }
            Column(modifier = Modifier
                .padding(start = 16.dp)) {
                Text(text = title,
                    color = Theme.colors.profileTitleColor,
                    fontWeight = FontWeight(500),
                    fontFamily = poppins,
                    fontSize = 10.sp)
                Text(text = mainText,
                    color = Theme.colors.profileMainText,
                    fontWeight = FontWeight(600),
                    fontFamily = roboto,
                    fontSize = 14.sp)
            }
        }
        IconButton(
            onClick = {

            }
        ) {
            Icon(painter = painterResource(editIcon),
                contentDescription = null,
                tint = Theme.colors.backIcon)
        }
    }
}