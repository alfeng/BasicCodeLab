package com.example.basiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccodelab.ui.theme.BasicCodelabTheme

class ConfigActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfigScreen()
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun ConfigPreview() {
        ConfigScreen()
    }

    @Composable
    private fun Background() {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.mipmap.background1),
            contentDescription = "background_image",
            contentScale = ContentScale.FillBounds
        )
    }

    @Composable
    private fun Title() {
        Text(text = "Launch options",
            color = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier.padding(8.dp, 16.dp, 8.dp, 32.dp).wrapContentWidth(),
            fontSize = 24.sp
        )
    }

    // Need to create a switch object with parameters
    @Composable
    private fun Switches() {
        val switchColors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            checkedTrackColor = MaterialTheme.colorScheme.inversePrimary,
            uncheckedThumbColor = MaterialTheme.colorScheme.inversePrimary,
            uncheckedTrackColor = MaterialTheme.colorScheme.primary,
        )

        val gameOnlyOn = remember { mutableStateOf(false) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Game Only", color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.padding(4.dp).wrapContentWidth(), fontSize = 18.sp)
            Switch(checked = gameOnlyOn.value, colors = switchColors, modifier = Modifier.padding(4.dp),
                onCheckedChange = { gameOnlyOn.value = !gameOnlyOn.value })
        }


    }

    @Composable
    private fun ConfigScreen()
    {
        BasicCodelabTheme {
            Box(contentAlignment = Alignment.TopCenter) {
                Background()
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp))
                {
                    Title()
                    Switches()
                }
            }
        }
    }
}
