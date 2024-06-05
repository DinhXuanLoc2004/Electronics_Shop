package com.example.demo_app_kotlin.asm.navigation.bottomTab

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ContainerBottomTab(
    Items: List<DataClassItem>,
    navControllerContainer: NavController
) {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar (
        modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        contentColor = Color.Transparent
    ){
        Items.forEachIndexed { index, dataClassItem ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navControllerContainer.navigate(dataClassItem.route)
                },
                icon = {
                    ItemView(
                        isSelected = selectedItemIndex == index,
                        selectedIcon = dataClassItem.selectedIcon,
                        unSelectedIcon = dataClassItem.unSelectedIcon,
                        route = dataClassItem.route
                    )
                }
            )
        }
    }

}