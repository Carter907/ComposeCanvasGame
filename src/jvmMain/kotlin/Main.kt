import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.onClick
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App() {
    var active by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            active = true;
            delay(1000);
            active = false;
        }

    }
    Canvas(modifier = Modifier.padding(10.dp)
        .fillMaxSize()
    ) {


        if (active) {
            drawRect(Color.Black)
            drawCircle(
                Color.Blue, 50f,
                Offset(
                    (1..size.width.toInt()).random().toFloat(),
                    (1..size.height.toInt()).random().toFloat()
                )
            )
        }
    }
}

suspend fun runOnUiThread(block: suspend () -> Unit) = withContext(Dispatchers.Main) { block() }
fun main() = application {

    Window(onCloseRequest = ::exitApplication) {

        App();

    }
}
