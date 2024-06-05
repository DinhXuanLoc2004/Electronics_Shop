package com.example.demo_app_kotlin.com_tam.components.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.demo_app_kotlin.R
import com.example.demo_app_kotlin.asm.components.customCpns.ButtonIconCustom

class Lab4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listImg = listOf(
            "https://afamilycdn.com/150157425591193600/2022/12/7/com-tam-suon-bi-cha-trung-anh-hoa-quynh-nguyen-1670317945936565526419-1670385940206-16703859407121546487016.jpg",
            "https://thumbs.dreamstime.com/b/com-tam-vietnamese-dish-broken-rice-served-grilled-pork-pickled-vegetables-fried-egg-generative-ai-black-table-277930279.jpg",
            "https://i-giadinh.vnecdn.net/2024/03/07/7Honthinthnhphm1-1709800144-8583-1709800424.jpg",
            "https://hawonkoo.vn/medias/hwk02/images/2023/10/cach-lam-com-tam-suon-bi-cha-ngon-chuan-vi-sai-gon-1.jpg",
        )
        setContent {
            lab4(listImg = listImg)
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun lab4(listImg: List<String>) {
    val pagerState = rememberPagerState(pageCount = { listImg.size })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff263238))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(213.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                ImgNetword(url = listImg[page])
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ButtonIconCustom(
                        icon = R.drawable.icon_back_lab3,
                        shape = 4,
                        width = 38,
                        height = 38,
                        elevation = 10,
                        onClick = { /*TODO*/ },
                        colorShadow = "ffffff"
                    )

                    ButtonIconCustom(
                        icon = R.drawable.icon_love_choose,
                        shape = 4,
                        width = 31,
                        height = 31,
                        elevation = 15,
                        onClick = { /*TODO*/ },
                        colorShadow = "FF7400"
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(pagerState.pageCount) { index ->
                        val color =
                            if (pagerState.currentPage == index) Color(0xffFF7400) else Color(
                                0xff979797
                            )

                        Box(
                            modifier = Modifier
                                .width(10.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(color = color)
                        )

                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
            ) {
                Text(
                    text = "Pizza Hut",
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    color = Color(0xffFF7400),
                    lineHeight = 20.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_start_lab3),
                            contentDescription = null,
                            modifier = Modifier
                                .width(17.dp)
                                .height(17.dp)
                                .shadow(
                                    elevation = 8.dp,
                                    shape = RoundedCornerShape(0.dp),
                                    spotColor = Color(android.graphics.Color.parseColor("#FFC529")),
                                    ambientColor = Color(android.graphics.Color.parseColor("#FFC529")),
                                    clip = true
                                )
                        )

                        Text(
                            text = "4.5",
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            color = Color.White,
                            modifier = Modifier.padding(start = 5.dp),
                            lineHeight = 16.sp
                        )

                        Text(
                            text = "(30+)",
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            color = Color(0xff9796A1),
                            modifier = Modifier.padding(start = 5.dp),
                            lineHeight = 14.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_items),
                            contentDescription = null,
                            modifier = Modifier
                                .width(12.dp)
                                .height(12.dp)
                        )

                        Text(
                            text = "80 items",
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            color = Color(0xffC0C0C0),
                            modifier = Modifier.padding(start = 5.dp),
                            lineHeight = 14.sp
                        )

                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Good",
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = Color(0xffFE724C)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_sao_feedback),
                        contentDescription = null,
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(0.dp),
                                spotColor = Color(android.graphics.Color.parseColor("#FFC529")),
                                ambientColor = Color(android.graphics.Color.parseColor("#FFC529")),
                                clip = true
                            )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.icon_sao_feedback),
                        contentDescription = null,
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(0.dp),
                                spotColor = Color(android.graphics.Color.parseColor("#FFC529")),
                                ambientColor = Color(android.graphics.Color.parseColor("#FFC529")),
                                clip = true
                            )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.icon_sao_feedback),
                        contentDescription = null,
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(0.dp),
                                spotColor = Color(android.graphics.Color.parseColor("#FFC529")),
                                ambientColor = Color(android.graphics.Color.parseColor("#FFC529")),
                                clip = true
                            )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.icon_sao_feedback),
                        contentDescription = null,
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(0.dp),
                                spotColor = Color(android.graphics.Color.parseColor("#FFC529")),
                                ambientColor = Color(android.graphics.Color.parseColor("#FFC529")),
                                clip = true
                            )
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Image(
                        painter = painterResource(id = R.drawable.icon_sao_rong),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    painter = painterResource(id = R.drawable.img_white),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(168.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        ),
                    contentScale = ContentScale.FillBounds
                )
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)){
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffFF7400),
                        disabledContainerColor = Color(0xffFF7400),
                        contentColor = Color(0xffFF7400),
                        disabledContentColor = Color(0xffFF7400)
                    ),
                    shape = RoundedCornerShape(8.dp)
                    ) {
                    Text(
                        text = "SubmitSubmit",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        color = Color.White,
                        lineHeight = 17.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ImgNetword(url: String) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .size(Size.ORIGINAL)
            .build()
    )
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize(),
    )
}

