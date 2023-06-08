package com.example.basiccodelab

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccodelab.ui.theme.BasicCodelabTheme

class PatchingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Progress()
                }
            }
        }
    }
}

@Composable
fun Progress() {
    val progressAmount = remember { mutableStateOf(0.5f) }
    val showDetails = remember { mutableStateOf(true) }
    Column(modifier = Modifier.padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Updating game data", modifier = Modifier.padding(4.dp, 8.dp, 4.dp, 32.dp))
        Text(text = "...", modifier = Modifier.padding(4.dp, 4.dp, 4.dp, 16.dp))
        LinearProgressIndicator(progressAmount.value, modifier = Modifier.padding(4.dp))
        ElevatedButton(modifier = Modifier.padding(4.dp, 48.dp, 4.dp, 4.dp),
            onClick = {
                showDetails.value = !showDetails.value
            }
        ) {
            Text(if (showDetails.value) "Hide details" else "Show details")
        }
        if (showDetails.value) {
            Tty()
        }
    }
}

@Composable
fun Tty() {
    val logState = rememberScrollState(0)
    LaunchedEffect(Unit) { logState.scrollTo(logState.maxValue) }
    Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(8.dp, 8.dp, 24.dp, 8.dp)
            .verticalScroll(logState)
    ) {
        repeat(40) {
            Text("Line $it of tty...", modifier = Modifier.padding(2.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PatchingPreview() {
    BasicCodelabTheme {
        Progress()
    }
}
