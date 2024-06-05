package com.example.demo_app_kotlin.demo_sreen.customCpnsDemo


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_app_kotlin.R

@Composable
fun TextHeaderCustom(){
    Text(
        text = "Delivery of products",
        fontSize = 49.sp,
        fontFamily = FontFamily(Font(R.font.nunitosans_10pt_black)),
        color = Color(android.graphics.Color.parseColor("#45BC1B")),
        textAlign = TextAlign.Center,
        lineHeight = 39.sp,
        modifier = Modifier.padding(top = 70.dp)
    )
}