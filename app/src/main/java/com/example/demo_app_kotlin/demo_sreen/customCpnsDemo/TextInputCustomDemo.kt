package com.example.demo_app_kotlin.demo_sreen.customCpnsDemo


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_app_kotlin.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputCustomDemo(marginTop: Int, textLabel: String, valueChange: MutableState<String>){
    Surface (
        modifier = Modifier.padding(top = marginTop.dp)
    ){
        OutlinedTextField(
            value = valueChange.value,
            onValueChange = { valueChange.value = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "$textLabel",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_10pt_medium)),
                    color = Color(android.graphics.Color.parseColor("#6AC949"))
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(android.graphics.Color.parseColor("#6AC949")),
                unfocusedBorderColor = Color(android.graphics.Color.parseColor("#6AC949"))
            ),
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.nunitosans_10pt_medium)),
                color = Color(android.graphics.Color.parseColor("#002100"))
            ),
            shape = RoundedCornerShape(16.dp)
        )
    }
}