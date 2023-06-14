package com.example.basiccodelab

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccodelab.ui.theme.BasicCodelabTheme

class UpdateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpdateScreen()
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun UpdatePreview() {
        UpdateScreen()
    }

    @Composable
    private fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Composable
    private fun Background() {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.mipmap.background),
            contentDescription = "background_image",
            contentScale = ContentScale.FillBounds
        )
    }

    @Composable
    private fun Title() {
        Text(text = "App update required",
            color = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier.padding(8.dp, 16.dp, 8.dp, 32.dp).wrapContentWidth(),
            fontSize = 24.sp
        )
    }

    @Composable
    private fun Instructions() {
        Text(text = "Click button to begin update.",
            color = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 24.dp).wrapContentWidth(),
            fontStyle = FontStyle.Italic,
            fontSize = 16.sp
        )
    }

    @Composable
    private fun UpdateButton() {
        val buttColors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.inversePrimary)

        ElevatedButton(modifier = Modifier.padding(8.dp).wrapContentSize(),
            colors = buttColors,
            onClick = {
                finish()
            }
        ) {
            Text("Update Now", fontSize = 24.sp)
        }
    }

    @Composable
    private fun UpdateScreen()
    {
        BasicCodelabTheme {
            Box(contentAlignment = Alignment.TopCenter) {
                Background()
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth().padding(8.dp))
                {
                    Title()
                    UpdateButton()
                    Instructions()
                }
            }
        }
    }
}
