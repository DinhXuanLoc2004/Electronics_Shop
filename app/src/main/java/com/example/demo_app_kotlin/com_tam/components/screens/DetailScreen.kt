package com.example.demo_app_kotlin.com_tam.components.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreen() {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color(0xff263238)
    ){
        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ){
            Column (
                modifier = Modifier.fillMaxSize()
                    .zIndex(0f)
            ){

            }
        }
    }
}