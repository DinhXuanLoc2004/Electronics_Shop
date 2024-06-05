package com.example.demo_app_kotlin.demo_sreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.demo_app_kotlin.R

data class Categories(
    val id_categories: Int,
    val name_category: String,
    val products: List<Product>
)

data class Product(
    val id_product: Int,
    val name_product: String,
    val img_product: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSreenDemo(navControllerContainer: NavHostController) {
    val Vagetable = listOf(
        Product(1, "Potato", R.drawable.potato),
        Product(2, "Carrot", R.drawable.carrot),
        Product(3, "Onion", R.drawable.onion),
        Product(4, "Potato", R.drawable.potato),
        Product(5, "Carrot", R.drawable.carrot),
        Product(6, "Onion", R.drawable.onion),
        Product(7, "Potato", R.drawable.potato),
        Product(8, "Carrot", R.drawable.carrot),
        Product(9, "Onion", R.drawable.onion),
    )
    val Grocery = listOf(
        Product(1, "Rice", R.drawable.rice),
        Product(2, "Buckwheat", R.drawable.buckwheat),
        Product(3, "Cous Cous", R.drawable.cous_cous),
        Product(4, "Rice", R.drawable.rice),
        Product(5, "Buckwheat", R.drawable.buckwheat),
        Product(6, "Cous Cous", R.drawable.cous_cous),
        Product(7, "Rice", R.drawable.rice),
        Product(8, "Buckwheat", R.drawable.buckwheat),
        Product(9, "Cous Cous", R.drawable.cous_cous),
        Product(10, "Rice", R.drawable.rice),
        Product(11, "Buckwheat", R.drawable.buckwheat),
        Product(12, "Cous Cous", R.drawable.cous_cous),
    )
    val For_home = listOf(
        Product(1, "Rug", R.drawable.rug),
        Product(2, "Screwdriver", R.drawable.screwdriver),
        Product(3, "Towel", R.drawable.towels),
        Product(4, "Rug", R.drawable.rug),
        Product(5, "Screwdriver", R.drawable.screwdriver),
        Product(6, "Towel", R.drawable.towels),
        Product(7, "Rug", R.drawable.rug),
        Product(8, "Screwdriver", R.drawable.screwdriver),
        Product(9, "Towel", R.drawable.towels),
        Product(10, "Rug", R.drawable.rug),
        Product(11, "Screwdriver", R.drawable.screwdriver),
        Product(12, "Towel", R.drawable.towels),
    )
    val ProductToCategories = listOf(
        Categories(1, "Vegetables", Vagetable),
        Categories(2, "Grocery", Grocery),
        Categories(3, "For home", For_home),
        Categories(4, "Vegetables", Vagetable),
        Categories(5, "Grocery", Grocery),
        Categories(6, "For home", For_home),
        Categories(7, "Vegetables", Vagetable),
        Categories(8, "Grocery", Grocery),
        Categories(9, "For home", For_home),
    )
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Your city",
                color = Color.Gray,
                fontSize = 16.sp
            )
            Row(horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "ic_location",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
                Surface(modifier = Modifier.width(5.dp)) {}
                Text(
                    text = "Tallin",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Surface(modifier = Modifier.width(5.dp)) {}
                Image(
                    painter = painterResource(id = R.drawable.ic_dropdown),
                    contentDescription = "ic_dropdown",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            TextField(
                value = "", onValueChange = {},
                label = {
                    Text(
                        text = "Search",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(android.graphics.Color.parseColor("#6B6D7B")),
                        textAlign = TextAlign.Center
                    )
                },
                placeholder = { Text(text = "Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(android.graphics.Color.parseColor("#EEEFF0")),
                    focusedIndicatorColor = Color.Transparent, // Màu của đường gạch dưới khi focus
                    unfocusedIndicatorColor = Color.Transparent, // Màu của đường gạch dưới khi không focus
                    disabledIndicatorColor = Color.Transparent, // Màu của đường gạch dưới khi bị disable
                    errorIndicatorColor = Color.Transparent // Màu của đường gạch dưới khi có lỗi
                ),
                shape = RoundedCornerShape(40.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search_gray),
                        contentDescription = null,
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(items = ProductToCategories,
                itemContent = { item ->
                    ItemCategory(name_category = item.name_category, products = item.products)
                }
            )
        }
    }
}

@Composable
fun ItemCategory(name_category: String, products: List<Product>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$name_category",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Surface(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
                shape = RoundedCornerShape(20.dp),
                color = Color(android.graphics.Color.parseColor("#EDF9E9")),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_next),
                    contentDescription = null
                )
            }
        }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 16.dp, top = 10.dp)
        ) {
            items(
                items = products,
                itemContent = { item ->
                    ItemProduct(
                        name = item.name_product,
                        img = item.img_product
                    )
                })
        }
    }
}

@Composable
fun ItemProduct(name: String, img: Int) {
    Surface(
        modifier = Modifier.padding(end = 7.dp)
    ) {
        Box(
            modifier = Modifier
                .width(134.67.dp)
                .height(94.dp)
                .background(
                    color = Color(android.graphics.Color.parseColor("#F5FBF3")),
                    shape = RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.TopStart
        ) {
            Text(
                text = "$name",
                modifier = Modifier.padding(top = 5.dp, start = 5.dp),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.nunitosans_10pt_bold)),
                color = Color(android.graphics.Color.parseColor("#1A1A1A"))
            )
            Surface(
                shape = RoundedCornerShape(bottomEnd = 12.dp),
                color = Color.Transparent
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        painter = painterResource(id = img),
                        contentDescription = null
                    )
                }
            }
        }
    }
}