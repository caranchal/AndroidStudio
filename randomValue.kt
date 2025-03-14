import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessTheNumberGame()
        }
    }
}

@Composable
fun GuessTheNumberGame() {
    var secretNumber by remember { mutableStateOf(Random.nextInt(1, 101)) }
    var userGuess by remember { mutableStateOf("") }
    var hint by remember { mutableStateOf("") }
    var attempts by remember { mutableStateOf(0) }
    fun checkGuess() {
        val guess = userGuess.toIntOrNull()
        if (guess != null) {
            attempts++
            when {
                guess < secretNumber -> hint = "Больше!"
                guess > secretNumber -> hint = "Меньше!"
                else -> hint = "Вы угадали! Число: $secretNumber"
            }
        } else {
            hint = "Введите корректное число!"
        }
    }
    fun startNewGame() {
        secretNumber = Random.nextInt(1, 101)
        userGuess = ""
        hint = ""
        attempts = 0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Угадай число от 1 до 100",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = userGuess,
            onValueChange = { userGuess = it },
            label = { Text("Ваше число") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { checkGuess() }) {
            Text("Угадать")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = hint, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Попытки: $attempts", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { startNewGame() }) {
            Text("Новая игра")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGuessTheNumberGame() {
    GuessTheNumberGame()
}
