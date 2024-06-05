package com.example.demo_app_kotlin.asm.components.customCpns


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_app_kotlin.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputCustom(textDetail: String, value: MutableState<String>, isTextInputPassWord: Boolean) {
    val icon_eye = R.drawable.eye
    val icon_dont_eye = R.drawable.dont_eye
    var an by remember { mutableStateOf(true) }
    Text(
        text = "$textDetail",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        fontSize = 14.sp,
        color = Color(android.graphics.Color.parseColor("#909090")),
        fontFamily = FontFamily(Font(R.font.nunitosans_10pt_regular))
    )
    TextField(
        value = value.value,
        onValueChange = { value.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ),
        maxLines = 1,
        singleLine = true,
        trailingIcon = if (isTextInputPassWord) {
            {
                IconButton(
                    onClick = { an = !an },
                    modifier = Modifier
                        .clickable { }
                        .padding(end = 20.dp)
                ) {
                    Icon(
                        painter = painterResource(if (an) icon_dont_eye else icon_eye), contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )
                }
            }
        } else {
            null
        },
        visualTransformation = if (an && isTextInputPassWord){
            PasswordVisualTransformation()
        }else{
            VisualTransformation.None
        },
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 14.sp
        )
    )
}