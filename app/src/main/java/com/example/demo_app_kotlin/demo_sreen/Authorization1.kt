package com.example.demo_app_kotlin.demo_sreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Authorization1() {
    var phone = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextHeaderCustom()
        TextDetailHeaderCustom(textDetail = "Authorization of Registration", margin = 40)
        TextInputCustomDemo(marginTop = 20, textLabel = "Enter phone number", valueChange = phone)
        ButtonCustomDemo(textButton = "Comfirm Login", marginTop = 30)
    }
}


