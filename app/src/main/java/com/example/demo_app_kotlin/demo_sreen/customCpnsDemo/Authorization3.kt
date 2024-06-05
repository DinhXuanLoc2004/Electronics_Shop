package com.example.demo_app_kotlin.demo_sreen.customCpnsDemo


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AUthorization3(){
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
        TextDetailHeaderCustom(textDetail = "Enter code for SMS", margin = 40)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = "", onValueChange = { /*TODO*/ },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(android.graphics.Color.parseColor("#6AC949")),
                    unfocusedBorderColor = Color(android.graphics.Color.parseColor("#6AC949"))
                )
            )
            OutlinedTextField(
                value = "", onValueChange = { /*TODO*/ },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(android.graphics.Color.parseColor("#6AC949")),
                    unfocusedBorderColor = Color(android.graphics.Color.parseColor("#6AC949"))
                )
            )
            OutlinedTextField(
                value = "", onValueChange = { /*TODO*/ },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(android.graphics.Color.parseColor("#6AC949")),
                    unfocusedBorderColor = Color(android.graphics.Color.parseColor("#6AC949"))
                )
            )
            OutlinedTextField(
                value = "", onValueChange = { /*TODO*/ },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(android.graphics.Color.parseColor("#6AC949")),
                    unfocusedBorderColor = Color(android.graphics.Color.parseColor("#6AC949"))
                )
            )
        }
        ButtonCustomDemo(textButton = "Request code via 59s", marginTop = 30)
    }
}