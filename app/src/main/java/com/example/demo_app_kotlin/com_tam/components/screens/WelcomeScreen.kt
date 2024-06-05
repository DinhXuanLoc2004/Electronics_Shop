package com.example.demo_app_kotlin.com_tam.components.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_app_kotlin.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelComeScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xffFF7400)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.logo_welcome_com_tam),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = "Orangic",
            fontSize = 50.sp,
            fontFamily = FontFamily(Font(R.font.ribeyemarrow_regular)),
            color = Color.White
        )
    }
}