package com.example.demo_app_kotlin.asm.components.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.demo_app_kotlin.R
import com.example.demo_app_kotlin.asm.components.customCpns.CpnHeaderWelcome
import com.example.demo_app_kotlin.asm.components.customCpns.ShadowCustom
import com.example.demo_app_kotlin.asm.components.customCpns.TextInputCustom

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginSreen(navControllerContainer: NavHostController) {
    var email = remember { mutableStateOf("") }
    var passWord = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            CpnHeaderWelcome()
        }

        Column(
            modifier = Modifier.padding(top = 20.dp, start = 30.dp)
        ) {
            Text(
                text = "Hello !",
                color = Color(android.graphics.Color.parseColor("#909090")),
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.merriweather_regular))
            )
            Text(
                text = "WELCOME BACK",
                color = Color(android.graphics.Color.parseColor("#303030")),
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.merriweather_bold)),
                modifier = Modifier.padding(top = 15.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp, end = 40.dp, bottom = 40.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .drawBehind { ShadowCustom() }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    TextInputCustom(
                        textDetail = "Email",
                        value = email,
                        isTextInputPassWord = false
                    )
                    TextInputCustom(
                        textDetail = "Password",
                        value = passWord,
                        isTextInputPassWord = true
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp, vertical = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            text = "Forgot Password",
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                            color = Color(android.graphics.Color.parseColor("#303030")),
                            modifier = Modifier.padding(bottom = 30.dp)
                        )
                    }
                    ElevatedButton(
                        onClick = { navControllerContainer.navigate("MainTab") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .shadow(
                                elevation = 10.dp,
                                shape = RoundedCornerShape(10.dp),
                                ambientColor = Color.Black,
                                spotColor = Color.Black
                            ),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.elevatedButtonColors(
                            Color(android.graphics.Color.parseColor("#242424"))
                        )
                    ) {
                        Text(
                            text = "Log in",
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                            color = Color.White,
                        )
                    }

                    TextButton(onClick = { navControllerContainer.navigate("RegisterScreen") }) {
                        Text(
                            text = "SIGN UP",
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                            color = Color(android.graphics.Color.parseColor("#303030")),
                            modifier = Modifier.padding(top = 30.dp)
                        )
                    }
                }
            }
        }
    }
}





