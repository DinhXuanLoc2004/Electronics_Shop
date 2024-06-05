package com.example.demo_app_kotlin.demo_sreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demo_app_kotlin.demo_sreen.customCpnsDemo.ButtonCustomDemo
import com.example.demo_app_kotlin.demo_sreen.customCpnsDemo.TextDetailHeaderCustom
import com.example.demo_app_kotlin.demo_sreen.customCpnsDemo.TextHeaderCustom
import com.example.demo_app_kotlin.demo_sreen.customCpnsDemo.TextInputCustomDemo

@Preview
@Composable
fun Authorization2(){
    var password = remember {
        mutableStateOf("")
    }
    var passwordComfirm = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextHeaderCustom()
        TextDetailHeaderCustom(textDetail = "Create a password", margin = 40)
        TextInputCustomDemo(marginTop = 20, textLabel = "Enter phone number", valueChange = password)
        TextInputCustomDemo(marginTop = 20, textLabel = "Enter phone number", valueChange = passwordComfirm)
        ButtonCustomDemo(textButton = "Continue", marginTop = 30)
    }
}