package com.example.demo_app_kotlin.demo_sreen.customCpnsDemo

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_app_kotlin.R

@Composable
fun ButtonCustomDemo(textButton: String, marginTop: Int) {
    Surface (modifier = Modifier.padding(top = marginTop.dp)){
        ElevatedButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                Color(android.graphics.Color.parseColor("#45BC1B"))
            )
        ) {
            Text(text = "$textButton",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.nunitosans_10pt_bold))
            )
        }
    }
}