package com.example.basiccodelab

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
    private fun ConfigScreen()
    {
        BasicCodelabTheme {
            Box(contentAlignment = Alignment.TopCenter) {
                Background()
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth().padding(8.dp))
                {
                    Title()
                    Switches()
                    Username()
                    Arguments()
                    LaunchButton()
                    Version()
                }
            }
        }
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
            modifier = Modifier
                .padding(8.dp, 16.dp, 8.dp, 16.dp)
                .wrapContentWidth(),
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

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            val gameOnlyOn = remember { mutableStateOf(false) }
            val aiVaiOn = remember { mutableStateOf(false) }
            val noCrowd = remember { mutableStateOf(false) }
            val sandbox = remember { mutableStateOf(false) }
            val patching = remember { mutableStateOf(false) }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Game Only", color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier.padding(4.dp).wrapContentWidth(), fontSize = 18.sp)
                Switch(checked = gameOnlyOn.value, colors = switchColors, modifier = Modifier.padding(4.dp),
                    onCheckedChange = { gameOnlyOn.value = !gameOnlyOn.value })
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "AI vs AI", color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier.padding(4.dp).wrapContentWidth(), fontSize = 18.sp)
                Switch(checked = aiVaiOn.value, colors = switchColors, modifier = Modifier.padding(4.dp),
                    onCheckedChange = { aiVaiOn.value = !aiVaiOn.value })
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "No Crowd", color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier.padding(4.dp).wrapContentWidth(), fontSize = 18.sp)
                Switch(checked = noCrowd.value, colors = switchColors, modifier = Modifier.padding(4.dp),
                    onCheckedChange = { noCrowd.value = !noCrowd.value })
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Sandbox", color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier.padding(4.dp).wrapContentWidth(), fontSize = 18.sp)
                Switch(checked = sandbox.value, colors = switchColors, modifier = Modifier.padding(4.dp),
                    onCheckedChange = { sandbox.value = !sandbox.value })
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Patching", color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier.padding(4.dp).wrapContentWidth(), fontSize = 18.sp)
                Switch(checked = patching.value, colors = switchColors, modifier = Modifier.padding(4.dp),
                    onCheckedChange = { patching.value = !patching.value })
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Username() {
        val username = remember { mutableStateOf("") }
        OutlinedTextField(
            value = username.value,
            modifier = Modifier.padding(8.dp),
            onValueChange = { newText ->
                username.value = newText },
            label = { Text("Username") },
            placeholder = { Text("(Recap tag)") }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Arguments() {
        val arguments = remember { mutableStateOf("") }
        OutlinedTextField(
            value = arguments.value,
            modifier = Modifier.padding(8.dp),
            onValueChange = { newText ->
                arguments.value = newText },
            label = { Text("Command line arguments") },
            placeholder = { Text("(arguments)") }
        )
    }

    @Composable
    private fun LaunchButton() {
        val localContext = LocalContext.current
        val buttColors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.inversePrimary)

        ElevatedButton(modifier = Modifier.padding(22.dp).wrapContentSize(),
            colors = buttColors,
            onClick = {
                finish()
//                val intent = Intent(localContext, MainActivity::class.java)
//                ContextCompat.startActivity(localContext, intent, null)
            }
        ) {
            Text("Launch Game", fontSize = 16.sp)
        }
    }

    @Composable
    private fun Version() {
        Text(text = "Version number",
            color = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier
//                .align(Alignment.BottomCenter)
                .padding(8.dp, 32.dp, 8.dp, 8.dp)
                .wrapContentWidth(),
            fontSize = 18.sp
        )
    }
}
