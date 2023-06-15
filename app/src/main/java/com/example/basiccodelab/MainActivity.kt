package com.example.basiccodelab

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccodelab.ui.theme.BasicCodelabTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity

val nameList = listOf("World", "Compose")

// Material components
// https://developer.android.com/jetpack/compose/layouts/material
// https://m3.material.io/components

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen()
{
    BasicCodelabTheme {
        Box(contentAlignment = Alignment.Center) {
            Background()
            Buttons()
        }


//        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
//        }
    }
}

@Composable
private fun Background()
{
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(R.mipmap.background2),
        contentDescription = "background_image",
        contentScale = ContentScale.FillBounds
    )
}

@Composable
private fun Buttons()
{
    val localContext = LocalContext.current
    val buttColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.inversePrimary)

    Row {
        ElevatedButton(modifier = Modifier
            .padding(2.dp)
            .weight(0.33f)
            .wrapContentSize(),
            colors = buttColors,
            onClick = {
                val intent = Intent(localContext, ConfigActivity::class.java)
                startActivity(localContext, intent, null)
            }
        ) {
            Text("Config", fontSize = 16.sp)
        }

        ElevatedButton(modifier = Modifier
            .padding(2.dp)
            .weight(0.33f)
            .wrapContentSize(),
            colors = buttColors,
            onClick = {
                val intent = Intent(localContext, UpdateActivity::class.java)
                startActivity(localContext, intent, null)
            }
        ) {
            Text("Update", fontSize = 16.sp)
        }

        ElevatedButton(modifier = Modifier
            .padding(2.dp)
            .weight(0.33f)
            .wrapContentSize(),
            colors = buttColors,
            onClick = {
                val intent = Intent(localContext, PatchingActivity::class.java)
                startActivity(localContext, intent, null)
            }
        ) {
            Text("Patcher", fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}
