@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.demo_app_kotlin.asm.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demo_app_kotlin.R
import com.example.demo_app_kotlin.asm.components.screens.auth.LoginSreen
import com.example.demo_app_kotlin.asm.components.screens.auth.RegisterScreen
import com.example.demo_app_kotlin.asm.components.screens.auth.WelcomeSreen
import com.example.demo_app_kotlin.asm.components.screens.home.homeNotTab.CartScreen
import com.example.demo_app_kotlin.asm.components.screens.home.homeNotTab.DetailScreen
import com.example.demo_app_kotlin.asm.components.screens.home.homeTab.Product
import com.example.demo_app_kotlin.asm.navigation.bottomTab.MainTab
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch



@Composable
fun AsmNavigation(){
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    var isShowBottomSheet = remember { mutableStateOf(false) }
    var textContentBottomSheet = remember { mutableStateOf("") }

    val navControllerContainer: NavHostController = rememberNavController()

    Scaffold {
        paddingValues ->
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)){
            NavHost(navController = navControllerContainer, startDestination = "WelcomeScreen") {
                composable("WelcomeScreen") { WelcomeSreen(navControllerContainer) }
                composable("LoginScreen") { LoginSreen(navControllerContainer) }
                composable("RegisterScreen") { RegisterScreen(navControllerContainer, isShowBottomSheet, textContentBottomSheet) }

                composable("MainTab") { MainTab(navControllerContainer) }

                composable("DetailScreen/{product_detail}",
                    arguments = listOf(navArgument("product_detail") { type = NavType.StringType})
                ) { backStackEntry ->
                    val jsonString = backStackEntry.arguments?.getString("product_detail")
                    val ObjectProduct = Gson().fromJson(jsonString, Product::class.java)
                    DetailScreen(
                        navControllerContainer = navControllerContainer,
                        ObjectProduct
                    )
                }

                composable("CartScreen") { CartScreen(navControllerContainer)}
            }
        }
        if (isShowBottomSheet.value) {
            ModalBottomSheet(onDismissRequest = { coroutineScope.launch { sheetState.hide() }
                .invokeOnCompletion { isShowBottomSheet.value = false }}){
                containerContentBottomSheet(coroutineScope, sheetState, isShowBottomSheet, textContentBottomSheet)
            }
        }
    }

}


@Composable
fun containerContentBottomSheet(
    coroutineScope: CoroutineScope,
    sheetState: SheetState,
    isShowBottomSheet: MutableState<Boolean>,
    textContentBottomSheet: MutableState<String>
) {
    Column (
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween
    ){
        Text(text = "${textContentBottomSheet.value}")
        Spacer(modifier = Modifier.height(20.dp))
        ElevatedButton(
            onClick = { coroutineScope.launch { sheetState.hide() }.invokeOnCompletion { isShowBottomSheet.value = false } },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(10.dp),
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                ),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                Color(android.graphics.Color.parseColor("#242424"))
            )
        ) {
            Text(
                text = "OK",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                color = Color.White,
            )
        }
    }
}