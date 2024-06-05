package com.example.demo_app_kotlin.asm.components.screens.home.homeNotTab

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.demo_app_kotlin.R
import com.example.demo_app_kotlin.asm.components.customCpns.HeaderCustom

data class productInCart(
    val name: String,
    val img: Int,
    val price: Int,
    var quantity: Int
)

@Composable
fun CartScreen(navControllerContainer: NavHostController) {
    val ListProductInCart = remember {
        mutableListOf(
            productInCart("Minimal Stand", R.drawable.minimal_stand, 20, 1),
            productInCart("Coffee Chair", R.drawable.coffee_chair, 25, 1),
            productInCart("Minimal desk", R.drawable.simple_desk, 30, 1),
        )
    }

    var total = remember { mutableStateOf(0) }
    
    fun tinhTotal() {
        var sum = 0
        for (product in ListProductInCart){
            sum += product.price * product.quantity
        }
        total.value = sum
    }

    fun chanQuantity(product: productInCart, plus: Boolean){
        val index = ListProductInCart.indexOf(product)
        if (plus) {
            ListProductInCart[index].quantity++
            Log.d(">>>>>>", ListProductInCart[index].quantity.toString())
        }
        else {
            if (ListProductInCart[index].quantity > 0) {
                ListProductInCart[index].quantity--
                Log.d(">>>>>>", ListProductInCart[index].quantity.toString())
            }
            else {
                ListProductInCart.removeAt(index)
            }
        }
    }

    tinhTotal()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(0f)
        ) {
            HeaderCustom(
                icLeft = R.drawable.icon_back_asm,
                icRight = null,
                text1 = null,
                text2 = null,
                text3 = "My cart",
                fnLeft = { navControllerContainer.popBackStack() },
                fnRight = {}
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            ) {
                items(
                    items = ListProductInCart,
                    itemContent = { item ->
                        ItemCart(item,
                            plusFunction = {chanQuantity(item, true)}
                        ) { chanQuantity(item, false) }
                    }
                )
            }
        }

        Surface (
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(1f)
                .align(Alignment.BottomCenter)
                .background(Color.White.copy(alpha = 0.8f))
            ,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ){
            Column (
                modifier = Modifier.padding(horizontal = 20.dp)
            ){
                Spacer(modifier = Modifier.height(20.dp))

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color.White),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = "Enter your promo code",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans_10pt_regular)),
                        color = Color(0xff999999),
                        modifier = Modifier.padding(start = 20.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.icon_back_black),
                        contentDescription = null,
                        modifier = Modifier.size(44.dp)
                    )
                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Total:",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans_10pt_bold)),
                        color = Color(0xff808080)
                    )

                    Text(
                        text = "$ ${total.value}.00",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans_10pt_bold)),
                        color = Color(0xff303030)
                    )
                }

                ElevatedButton(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff242424),
                        disabledContainerColor = Color(0xff242424),
                        contentColor = Color(0xff242424),
                        disabledContentColor = Color(0xff242424),
                    )
                ) {
                    Text(
                        text = "Check out",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun ItemCart(item: productInCart, plusFunction: () -> Unit, minusFunction: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Image(
            painter = painterResource(id = item.img),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column {
                    Text(
                        text = "${item.name}",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                        color = Color(0xff999999)
                    )

                    Text(
                        text = "$ ${item.price}.00",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans_10pt_bold)),
                        color = Color(0xff242424),
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.icon_delete_favorite),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.icon_plus),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { plusFunction() }
                )

                Text(
                    text = "${item.quantity}",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                    color = Color(0xff242424),
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.icon_minus),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { minusFunction() }
                )
            }
        }
    }

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color(0xffF0F0F0))
    )
}
