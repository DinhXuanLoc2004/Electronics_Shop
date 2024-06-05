package com.example.demo_app_kotlin.asm.components.screens.auth

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.demo_app_kotlin.R

@Composable
fun WelcomeSreen(navControllerContainer: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.back_ground_welcom),
            contentDescription = "backGround",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "MAKE YOUR",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 231.dp, start = 30.dp),
                color = Color(android.graphics.Color.parseColor("#606060")),
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.gelasio_semibold))
            )
            Text(
                text = "HOME BEAUTIFUL",
                modifier = Modifier
                    .padding(top = 10.dp, start = 30.dp),
                color = Color(android.graphics.Color.parseColor("#303030")),
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.gelasio_bold))
            )
            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 59.dp, top = 20.dp, end = 10.dp),
                maxLines = 3,
                style = TextStyle(
                    lineHeight = 35.sp, // Đặt chiều cao của mỗi dòng là 20sp
                ),
                fontSize = 18.sp,
                color = Color(android.graphics.Color.parseColor("#808080")),
                fontFamily = FontFamily(Font(R.font.nunitosans_10pt_regular))
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 150.dp),
                horizontalArrangement = Arrangement.Center
            ){
                ElevatedButton(
                    onClick = { navControllerContainer.navigate("LoginScreen") },
                    modifier = Modifier
                        .width(159.dp)
                        .height(54.dp)
                        .shadow(
                            elevation = 10.dp,
                            shape = RoundedCornerShape(10.dp),
                            ambientColor = Color.Black,
                            spotColor = Color.Black
                        ),
                    colors = ButtonDefaults.elevatedButtonColors(Color(android.graphics.Color.parseColor("#242424"))),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Get Started",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.gelasio_semibold)),
                        color = Color.White
                    )
                }
            }
        }
    }
}