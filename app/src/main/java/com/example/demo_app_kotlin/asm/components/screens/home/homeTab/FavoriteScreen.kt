package com.example.demo_app_kotlin.asm.components.screens.home.homeTab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.demo_app_kotlin.R
import com.example.demo_app_kotlin.asm.components.customCpns.HeaderCustom

data class productFavorites(val name: String, val img: Int, val price: Int)

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun FavoriteScreen(navControllerContainer: NavHostController) {
    val data = listOf(
        productFavorites(
            "Coffee Chair",
            R.drawable.coffee_chair,
            20
        ),
        productFavorites(
            "Coffee Chair",
            R.drawable.coffee_chair,
            20
        ),
        productFavorites(
            "Coffee Chair",
            R.drawable.coffee_chair,
            20
        ),
        productFavorites(
            "Coffee Chair",
            R.drawable.coffee_chair,
            20
        ),
        productFavorites(
            "Coffee Chair",
            R.drawable.coffee_chair,
            20
        ),
        productFavorites(
            "Coffee Chair",
            R.drawable.coffee_chair,
            20
        ),
        productFavorites(
            "Coffee Chair",
            R.drawable.coffee_chair,
            20
        ),
        productFavorites(
            "Coffee Chair",
            R.drawable.coffee_chair,
            20
        ),
        productFavorites(
            "Coffee Chair",
            R.drawable.coffee_chair,
            20
        ),

    )
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column (modifier = Modifier
            .fillMaxSize()
            .zIndex(0f)){
            HeaderCustom(
                icLeft = R.drawable.search,
                icRight = R.drawable.ic_cart,
                text1 = null,
                text2 = null,
                text3 = "Favorites",
                fnRight = {},
                fnLeft = {})

            LazyColumn (modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)){
                items(
                    items = data,
                    itemContent = {item ->  ItemFavorite(item)}
                )
            }
        }

        Surface (modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .align(Alignment.BottomCenter)){
            ElevatedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .zIndex(1f)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(8.dp),
                        ambientColor = Color.Black,
                        spotColor = Color.Black,
                        clip = true
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff242424),
                    disabledContainerColor = Color(0xff242424),
                    contentColor = Color(0xff242424),
                    disabledContentColor = Color(0xff242424),
                ),
                shape = RoundedCornerShape(8.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(8.dp)
            ) {
                Text(
                    text = "Add all to my cart",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }

        }
    }

}

@Composable
fun ItemFavorite(item: productFavorites) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = item.img),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillBounds
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column (
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Top
            ){
                Text(
                    text = "${item.name}",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                    color = Color(0xff606060)
                )

                Text(
                    text = "$ ${item.price}.00",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_10pt_bold)),
                    color = Color(0xff303030),
                    modifier = Modifier.padding(top = 5.dp)
                )
            }

            Column (
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ){
                Box (
                    modifier = Modifier.size(34.dp),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_delete_favorite),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.icon_add_cart_favorite),
                    contentDescription = null,
                    modifier = Modifier.size(34.dp)
                )
            }
        }
    }
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(color = Color(0xffF0F0F0)))
}

