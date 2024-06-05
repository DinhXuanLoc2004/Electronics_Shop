package com.example.demo_app_kotlin.demo_sreen.customCpnsDemo


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_app_kotlin.R

@Composable
fun TextDetailHeaderCustom(textDetail: String, margin: Int){
    Text(
        text = "$textDetail",
        color = Color(android.graphics.Color.parseColor("#1A1A1A")),
        fontFamily = FontFamily(Font(R.font.nunitosans_10pt_bold)),
        fontSize = 20.sp,
        modifier = Modifier.padding(top = margin.dp)
    )
}