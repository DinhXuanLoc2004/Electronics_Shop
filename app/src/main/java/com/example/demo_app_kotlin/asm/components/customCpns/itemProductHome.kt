package com.example.demo_app_kotlin.asm.components.customCpns

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.demo_app_kotlin.R
import com.example.demo_app_kotlin.asm.components.screens.home.homeTab.Product
import com.google.gson.Gson

@Composable
fun itemProductHome(itemRow: List<Product>, navControllerContainer: NavHostController) {
    val gson = Gson()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 25.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (item in itemRow){
            val itemToJson = gson.toJson(item)
            Column {
                Surface (
                    color = Color.Transparent
                ){
                    Image(
                        painter = painterResource(id = item.imgs_product[0]),
                        contentDescription = null,
                        modifier = Modifier
                            .width(157.dp)
                            .height(200.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.FillBounds
                    )

                    Box (
                        modifier = Modifier
                            .width(157.dp)
                            .height(200.dp)
                            .padding(end = 10.dp, bottom = 10.dp),
                        contentAlignment = Alignment.BottomEnd
                    ){
                        ElevatedButton(
                            onClick = { navControllerContainer.navigate("DetailScreen/${itemToJson}") },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                contentColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
                            ),
                            elevation = null,
                            contentPadding = PaddingValues(0.dp),
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_add_to_cart),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp)
                            )
                        }
                    }
                }

                Text(
                    text = "${item.name_product}",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_10pt_regular)),
                    color = Color(android.graphics.Color.parseColor("#606060")),
                    modifier = Modifier.padding(top = 10.dp)
                )

                Text(
                    text = "$ ${item.price}.00",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_10pt_bold)),
                    color = Color(android.graphics.Color.parseColor("#303030")),
                    modifier = Modifier.padding(top = 7.dp)
                )
            }
        }
    }
}