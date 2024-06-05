package com.example.demo_app_kotlin.asm.components.customCpns

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demo_app_kotlin.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CpnHeaderWelcome(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(63.96.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Surface (
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .padding(horizontal = 30.dp),
            color = Color(android.graphics.Color.parseColor("#BDBDBD"))
        ){}
        Image(painter = painterResource(id = R.drawable.img_header_login),
            contentDescription = "img_header_login",
            modifier = Modifier.width(63.96.dp)
                .height(63.96.dp))
        Surface (
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .padding(horizontal = 30.dp),
            color = Color(android.graphics.Color.parseColor("#BDBDBD"))
        ){}
    }
}