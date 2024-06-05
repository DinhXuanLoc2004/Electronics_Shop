package com.example.demo_app_kotlin.asm.navigation.bottomTab

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo_app_kotlin.R
import com.example.demo_app_kotlin.asm.components.screens.home.homeTab.FavoriteScreen
import com.example.demo_app_kotlin.asm.components.screens.home.homeTab.HomeScreen
import com.example.demo_app_kotlin.asm.components.screens.home.homeTab.NotificationScreen
import com.example.demo_app_kotlin.asm.components.screens.home.homeTab.ProfileScreen

@Composable
fun MainTab(navControllerContainer: NavHostController) {
    val listItemsTab = listOf(
        DataClassItem(
            route = "HomeScreen",
            selectedIcon = R.drawable.icon_home_choose,
            unSelectedIcon = R.drawable.icon_home
        ),
        DataClassItem(
            route = "FavoriteScreen",
            selectedIcon = R.drawable.icon_favorite_choose,
            unSelectedIcon = R.drawable.icon_favorite
        ),
        DataClassItem(
            route = "NotificationScreen",
            selectedIcon = R.drawable.icon_notification_choose,
            unSelectedIcon = R.drawable.icon_notification
        ),
        DataClassItem(
            route = "ProfileScreen",
            selectedIcon = R.drawable.icon_profile_choose,
            unSelectedIcon = R.drawable.icon_profile
        ),
    )

    val Nav_Controller = rememberNavController()
    Scaffold(bottomBar = {
        ContainerBottomTab(
            Items = listItemsTab,
            navControllerContainer = Nav_Controller
        )
    }) { paddingValues ->
        NavHost(navController = Nav_Controller, startDestination = listItemsTab[0].route, modifier = Modifier.padding(paddingValues)) {
            composable(listItemsTab[0].route) { HomeScreen(navControllerContainer = navControllerContainer)}
            composable(listItemsTab[1].route) { FavoriteScreen(navControllerContainer = navControllerContainer) }
            composable(listItemsTab[2].route) { NotificationScreen(navControllerContainer = navControllerContainer) }
            composable(listItemsTab[3].route) { ProfileScreen(navControllerContainer = navControllerContainer) }
        }
    }
}