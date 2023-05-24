package com.example.basiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
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
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

val nameList = listOf("World", "Compose")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
                    Greeting(nameList)
                }
            }
        }
    }
}

@Composable
fun Greeting(names: List<String>) {
    val expanded = remember { mutableStateOf(false) }
    Surface(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.wrapContentSize().clip(RoundedCornerShape(10))) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            val mods = Modifier.wrapContentSize(align = Alignment.Center).border(2.dp, Color.Red, RoundedCornerShape(10)).padding(8.dp).weight(0.5f)
            Column(mods) {
                val mods2 = Modifier.wrapContentSize(align = Alignment.Center).border(2.dp, Color.Yellow, RoundedCornerShape(30)).padding(8.dp)
                for (name in names) {
                    Surface(color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(4.dp).wrapContentSize().clip(RoundedCornerShape(30))) {
                        Text(text = "Hello $name!", modifier = mods2)
                    }
                }
            }
            ElevatedButton(modifier = Modifier.padding(8.dp).weight(0.5f),
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show Less" else "Show More")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicCodelabTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
            Greeting(nameList)
        }
    }
}
