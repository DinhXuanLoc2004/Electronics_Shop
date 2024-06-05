package com.example.demo_app_kotlin.asm.components.screens.home.homeTab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.demo_app_kotlin.R
import com.example.demo_app_kotlin.asm.components.customCpns.HeaderCustom
import com.example.demo_app_kotlin.asm.components.customCpns.itemCategory
import com.example.demo_app_kotlin.asm.components.customCpns.itemProductHome

data class Category(
    val id_category: Int,
    val name_category: String,
    val img_categoryUnfocus: Int,
    val img_categoryFocus: Int
)

data class Product(
    val id_product: Int,
    val name_product: String,
    val price: Int,
    val imgs_product: List<Int>
)

@Composable
fun HomeScreen(navControllerContainer: NavHostController) {
    var numberChoose = remember { mutableStateOf(1) }
    val Categories = listOf(
        Category(1, "Popular", R.drawable.start, R.drawable.start_focus),
        Category(2, "Chair", R.drawable.ghe, R.drawable.ghe_focus),
        Category(3, "Table", R.drawable.table, R.drawable.table_focus),
        Category(4, "Armchair", R.drawable.sofa, R.drawable.sofa_focus),
        Category(5, "Bed", R.drawable.bed, R.drawable.bed_focus),
        Category(6, "Popular", R.drawable.start, R.drawable.start_focus),
        Category(7, "Chair", R.drawable.ghe, R.drawable.ghe_focus),
        Category(8, "Table", R.drawable.table, R.drawable.table_focus),
        Category(9, "Armchair", R.drawable.sofa, R.drawable.sofa_focus),
        Category(10, "Bed", R.drawable.bed, R.drawable.bed_focus),
        Category(11, "Popular", R.drawable.start, R.drawable.start_focus),
        Category(12, "Chair", R.drawable.ghe, R.drawable.ghe_focus),
        Category(13, "Table", R.drawable.table, R.drawable.table_focus),
        Category(14, "Armchair", R.drawable.sofa, R.drawable.sofa_focus),
        Category(15, "Bed", R.drawable.bed, R.drawable.bed_focus),
    )
    val Products = listOf(
        Product(
            1,
            "Black Simple Lamp",
            12,
            listOf(
                R.drawable.black_simple_lamp,
                R.drawable.black_simple_lamp,
                R.drawable.black_simple_lamp
            )
        ),
        Product(
            2,
            "Minimal Stand",
            25,
            listOf(R.drawable.minimal_stand, R.drawable.minimal_stand, R.drawable.minimal_stand)
        ),
        Product(
            3,
            "Coffee Chair",
            20,
            listOf(R.drawable.coffee_chair, R.drawable.coffee_chair, R.drawable.coffee_chair)
        ),
        Product(
            4,
            "Simple Desk",
            50,
            listOf(R.drawable.simple_desk, R.drawable.simple_desk, R.drawable.simple_desk)
        ),
        Product(
            5,
            "Black Simple Lamp",
            12,
            listOf(
                R.drawable.black_simple_lamp,
                R.drawable.black_simple_lamp,
                R.drawable.black_simple_lamp
            )
        ),
        Product(
            6,
            "Minimal Stand",
            25,
            listOf(R.drawable.minimal_stand, R.drawable.minimal_stand, R.drawable.minimal_stand)
        ),
        Product(
            7,
            "Coffee Chair",
            20,
            listOf(R.drawable.coffee_chair, R.drawable.coffee_chair, R.drawable.coffee_chair)
        ),
        Product(
            8,
            "Simple Desk",
            50,
            listOf(R.drawable.simple_desk, R.drawable.simple_desk, R.drawable.simple_desk)
        ),
        Product(
            9,
            "Black Simple Lamp",
            12,
            listOf(
                R.drawable.black_simple_lamp,
                R.drawable.black_simple_lamp,
                R.drawable.black_simple_lamp
            )
        ),
        Product(
            10,
            "Minimal Stand",
            25,
            listOf(R.drawable.minimal_stand, R.drawable.minimal_stand, R.drawable.minimal_stand)
        ),
        Product(
            11,
            "Coffee Chair",
            20,
            listOf(R.drawable.coffee_chair, R.drawable.coffee_chair, R.drawable.coffee_chair)
        ),
        Product(
            12,
            "Simple Desk",
            50,
            listOf(R.drawable.simple_desk, R.drawable.simple_desk, R.drawable.simple_desk)
        ),
        Product(
            13,
            "Black Simple Lamp",
            12,
            listOf(
                R.drawable.black_simple_lamp,
                R.drawable.black_simple_lamp,
                R.drawable.black_simple_lamp
            )
        ),
        Product(
            14,
            "Minimal Stand",
            25,
            listOf(R.drawable.minimal_stand, R.drawable.minimal_stand, R.drawable.minimal_stand)
        ),
        Product(
            15,
            "Coffee Chair",
            20,
            listOf(R.drawable.coffee_chair, R.drawable.coffee_chair, R.drawable.coffee_chair)
        )
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderCustom(
            icLeft = R.drawable.search,
            icRight = R.drawable.ic_cart,
            text1 = "Make home",
            text2 = "BEAUTIFUL",
            text3 = null,
            fnRight = {navControllerContainer.navigate("CartScreen")},
            fnLeft = {}
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp)
        ) {
            items(
                items = Categories,
                itemContent = { item ->
                    itemCategory(
                        name_category = item.name_category,
                        img_categoryUnfocus = item.img_categoryUnfocus,
                        img_categoryFocus = item.img_categoryFocus,
                        id_category = item.id_category,
                        numberChoose = numberChoose
                    )
                }
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp, start = 20.dp, end = 20.dp)
        ) {
            items(Products.chunked(2)){ itemRow ->
                itemProductHome(itemRow = itemRow, navControllerContainer)
            }
        }
    }
}






