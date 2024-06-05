package com.example.demo_app_kotlin.com_tam.components.customCpnsLabs


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_app_kotlin.R

@Composable
fun TextHeaderDetail(text1: String, text2: String, marginTop: Int, maxLine: Int, with: Int) {
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color(android.graphics.Color.parseColor("#C0C0C0")))){
            append("$text1")
        }
        withStyle(style = SpanStyle(color = Color(android.graphics.Color.parseColor("#FF7400")))){
            append("$text2")
        }
    }

    Text(
        text = annotatedText,
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        lineHeight = 16.sp,
        modifier = Modifier.width(width = with.dp).padding(top = marginTop.dp),
        maxLines = maxLine
    )
}