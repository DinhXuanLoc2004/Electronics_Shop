package com.example.demo_app_kotlin.asm.components.customCpns

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_app_kotlin.R

@Composable
fun itemCategory(
    name_category: String,
    img_categoryUnfocus: Int,
    id_category: Int,
    numberChoose: MutableState<Int>,
    img_categoryFocus: Int
) {
    Surface(
        modifier = Modifier.padding(end = 20.dp)
    ) {
        ElevatedButton(
            onClick = { numberChoose.value = id_category },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                contentColor = Color.Transparent,
                disabledContentColor = Color.Transparent
            ),
            elevation = null,
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(4.dp)
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(44.dp)
                        .height(44.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            if (id_category == numberChoose.value) Color(android.graphics.Color.parseColor("#303030"))
                            else Color(android.graphics.Color.parseColor("#F5F5F5"))
                        )
                ) {
                    Image(
                        painter = painterResource(
                            id = if (id_category == numberChoose.value) img_categoryFocus else img_categoryUnfocus
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )
                }

                Text(
                    text = "$name_category",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                    color = if (id_category == numberChoose.value) Color(android.graphics.Color.parseColor("#242424"))
                    else Color(android.graphics.Color.parseColor("#999999")),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 7.dp)
                )
            }

        }
    }
}