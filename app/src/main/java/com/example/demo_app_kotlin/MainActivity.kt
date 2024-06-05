package com.example.demo_app_kotlin

import android.icu.util.Calendar
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.postDelayed
import com.example.demo_app_kotlin.asm.components.screens.auth.WelcomeSreen
import com.example.demo_app_kotlin.asm.navigation.AsmNavigation
import com.example.demo_app_kotlin.ui.theme.Demo_App_KotlinTheme
import kotlinx.coroutines.Runnable
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AsmNavigation()
        }
    }
}

@Composable
fun ListData(){
        // mảng gồm 100 phần tử
        val names = listOf(
            "A", "B", "C", "D"
        ) + ((0..100).map { it.toString() })
        // hiển thị danh sách
        LazyColumn {
            items(items = names, itemContent = { item ->  Hello(name = item)})
        }

}


@Composable
fun Hello(name: String){
    val expanded = remember {
        mutableStateOf(false)
    }
    fun toggle(){
        expanded.value = !expanded.value
    }
    Surface (modifier = Modifier
        .fillMaxWidth()
        .height(height = 50.dp)){
        Row (modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)){
                Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Avatar",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape))

            Surface (modifier = Modifier.weight(1f)){
                Text(text = name, modifier = Modifier.size(20.dp))
            }
            Surface (modifier = Modifier.weight(1f)){
                //Button
                ElevatedButton(onClick = { toggle() }) {
                    Text(text = if (expanded.value) "true" else "false")
                }
            }
        }
    }
}

