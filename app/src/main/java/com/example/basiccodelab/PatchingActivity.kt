package com.example.basiccodelab

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccodelab.ui.theme.BasicCodelabTheme

class PatchingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatchScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PatchingPreview() {
    PatchScreen()
}

@Composable
private fun PatchScreen()
{
    BasicCodelabTheme {
        Box(contentAlignment = Alignment.TopCenter) {
            Background()
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Title()
                ProgressBar(0.25f, "Downloading patch")
                PatchDetails()
            }
        }
    }
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
    Text(text = "Updating game data",
        color = MaterialTheme.colorScheme.inversePrimary,
        modifier = Modifier
            .padding(8.dp, 16.dp, 8.dp, 24.dp)
            .wrapContentWidth(),
        fontSize = 24.sp
    )
}

@Composable
private fun ProgressBar(amount: Float, status: String) {
    val progressAmount = remember { mutableStateOf(0.0f) }

    // Progress status
    Text(text = status, color = MaterialTheme.colorScheme.inversePrimary,
        modifier = Modifier
            .padding(4.dp, 4.dp, 4.dp, 8.dp)
            .wrapContentWidth()
    )

    // Progress amount
    progressAmount.value = amount
    LinearProgressIndicator(progressAmount.value,
        modifier = Modifier.padding(4.dp),
        trackColor = MaterialTheme.colorScheme.primary,
        color = MaterialTheme.colorScheme.inversePrimary
    )
}

@Composable
private fun PatchDetails() {
    val showLog = remember { mutableStateOf(true) }

    val buttColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.inversePrimary)

    // Toggle Button
    ElevatedButton(modifier = Modifier.wrapContentSize().padding(8.dp, 64.dp, 8.dp, 16.dp),
        colors = buttColors,
        onClick = {
            showLog.value = !showLog.value
        }
    ) {
        Text(if (showLog.value) "Hide details" else "Show details", fontSize = 18.sp)
    }

    // Log output
    if (showLog.value) {
        ShowLog()
    }
}

@Composable
private fun ShowLog() {
    // Always scroll to the bottom when first displayed
    val logState = rememberScrollState(0)
    LaunchedEffect(Unit) { logState.scrollTo(logState.maxValue) }

    // Log text
    Column(modifier = Modifier
        .background(Color(0x88444455))
        .padding(8.dp)
        .fillMaxWidth()
        .verticalScroll(logState)
    ) {
        repeat(40) {
            Text("Line $it of tty... Line $it of tty... Line $it of tty...",
                modifier = Modifier.padding(2.dp),
                color = MaterialTheme.colorScheme.inversePrimary)
        }
    }
}
