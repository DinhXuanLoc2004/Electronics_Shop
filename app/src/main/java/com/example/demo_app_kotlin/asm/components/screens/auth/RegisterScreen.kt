@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.demo_app_kotlin.asm.components.screens.auth


import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.demo_app_kotlin.R
import com.example.demo_app_kotlin.asm.components.customCpns.CpnHeaderWelcome
import com.example.demo_app_kotlin.asm.components.customCpns.ShadowCustom
import com.example.demo_app_kotlin.asm.components.customCpns.TextInputCustom
import com.example.demo_app_kotlin.asm.helper.RetrofitAPI
import com.example.demo_app_kotlin.asm.httpModel.userModel.RegisterRequestModel


@Composable
fun RegisterScreen(
    navControllerContainer: NavHostController,
    isShowBottomSheet: MutableState<Boolean>,
    textContentBottomSheet: MutableState<String>
) {
    var name = remember { mutableStateOf("") }
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    var ConfirmPassword = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        CpnHeaderWelcome()

        Text(
            text = "WELCOME",
            modifier = Modifier.padding(top = 20.dp, start = 30.dp),
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.merriweather_bold))
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 25.dp, end = 30.dp, bottom = 40.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .drawBehind {
                        ShadowCustom()
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    TextInputCustom(textDetail = "Name", value = name, isTextInputPassWord = false)
                    TextInputCustom(
                        textDetail = "Email",
                        value = email,
                        isTextInputPassWord = false
                    )
                    TextInputCustom(
                        textDetail = "Password",
                        value = password,
                        isTextInputPassWord = true
                    )
                    TextInputCustom(
                        textDetail = "Confirm Password",
                        value = ConfirmPassword,
                        isTextInputPassWord = true
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ElevatedButton(
                        onClick = { onClickRegister(name, email, password, ConfirmPassword, isShowBottomSheet, textContentBottomSheet) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .shadow(
                                elevation = 10.dp,
                                shape = RoundedCornerShape(10.dp),
                                ambientColor = androidx.compose.ui.graphics.Color.Black,
                                spotColor = androidx.compose.ui.graphics.Color.Black
                            ),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.elevatedButtonColors(
                            Color(android.graphics.Color.parseColor("#242424"))
                        )
                    ) {
                        Text(
                            text = "SIGN UP",
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                            color = androidx.compose.ui.graphics.Color.White,
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = { navControllerContainer.popBackStack() }) {
                            Text(
                                text = "Already have account?",
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                                color = Color(android.graphics.Color.parseColor("#808080"))
                            )
                            Text(
                                text = "SIGN IN",
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.nunitosans_10pt_bold)),
                                color = Color(android.graphics.Color.parseColor("#303030"))
                            )
                        }
                    }
                }
            }
        }

    }

}

fun onClickRegister(
    name: MutableState<String>,
    email: MutableState<String>,
    password: MutableState<String>,
    ConfirmPassword: MutableState<String>,
    isShowBottomSheet: MutableState<Boolean>,
    textContentBottomSheet: MutableState<String>,
    ) {
    try {
        if (name.value.isEmpty() || email.value.isEmpty() || password.value.isEmpty() || ConfirmPassword.value.isEmpty()){
            isShowBottomSheet.value = true
            textContentBottomSheet.value = "Vui lòng điền đầy đủ thông tin!"
            return
        }
        if (!isValidEmail(email.value)){
            isShowBottomSheet.value = true
            textContentBottomSheet.value = "Email không hợp lệ!"
            return
        }
        if (password.value != ConfirmPassword.value){
            isShowBottomSheet.value = true
            textContentBottomSheet.value = "Password và ConfirmPassword không giống nhau!"
            return
        }

        val retrofitAPI = RetrofitAPI()
        val body = RegisterRequestModel(email = email.value, password = password.value, fullname = name.value)
        retrofitAPI.register(body = body, callback = {})
    }catch (e: Exception){
        Log.d("", "onClickRegister: ${e.message}")
    }
}

fun callBackRegister(){

}

fun isValidEmail(email: String): Boolean {
    val pattern = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    return pattern.matches(email)
}

