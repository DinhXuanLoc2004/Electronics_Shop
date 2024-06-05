package com.example.demo_app_kotlin.asm.components.customCpns


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_app_kotlin.R

@Composable
fun HeaderCustom(
    icLeft: Int,
    icRight: Int?,
    text1: String?,
    text2: String?,
    text3: String?,
    fnRight: () -> Unit,
    fnLeft: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icLeft),
            contentDescription = null,
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .clickable { fnLeft() }
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (text3 == null){
                Text(
                    text = "$text1",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.gelasio_regular)),
                    color = Color(android.graphics.Color.parseColor("#909090")),
                    lineHeight = 25.sp
                )

                Text(
                    text = "$text2",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.gelasio_bold)),
                    color = Color(android.graphics.Color.parseColor("#242424")),
                    lineHeight = 25.sp
                )
            }else{
                Text(
                    text = "$text3",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.merriweather_bold)),
                    color = Color(android.graphics.Color.parseColor("#303030"))
                )
            }
        }

        Surface (
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
        ){
            icRight?.let { painterResource(id = it) }?.let {
                Image(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .clickable { fnRight() }
                )
            }
        }
    }
}