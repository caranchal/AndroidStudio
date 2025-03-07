package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quizapp.ui.theme.QuizAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    QuizApp()
                }
            }
        }
    }
}

@Composable
fun QuizApp() {
    var difficulty by remember { mutableStateOf<Difficulty?>(null) }
    var questions by remember { mutableStateOf(emptyList<Question>()) }
    var currentQuestion by remember { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableStateOf("") }
    var score by remember { mutableIntStateOf(0) }
    var quizFinished by remember { mutableStateOf(false) }
    var enabledButton by remember { mutableStateOf(false) }

    if (difficulty == null) {
        DifficultySelectionScreen { selectedDifficulty ->
            difficulty = selectedDifficulty
            questions = when (selectedDifficulty) {
                Difficulty.EASY -> easyQuestions
                Difficulty.MEDIUM -> mediumQuestions
                Difficulty.HARD -> hardQuestions
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!quizFinished) {
                Text(text = "Вопрос: ${questions[currentQuestion].text}")
                Spacer(modifier = Modifier.height(12.dp))

                questions[currentQuestion].options.forEach { option ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedAnswer == option,
                            onClick = {
                                selectedAnswer = option
                                enabledButton = true
                            }
                        )
                        Text(text = option)
                    }
                }

                Button(
                    onClick = {
                        if (selectedAnswer == questions[currentQuestion].correctAnswer) {
                            score++
                        }
                        if (currentQuestion < questions.size - 1) {
                            currentQuestion++
                        } else {
                            quizFinished = true
                        }
                        selectedAnswer = ""
                        enabledButton = false
                    },
                    enabled = enabledButton
                ) {
                    Text(text = if (currentQuestion < questions.size - 1) "Следующий вопрос" else "Закончить")
                }
            } else {
                Text(text = "Ваш результат: $score/${questions.size}")
                Button(onClick = {
                    quizFinished = false
                    currentQuestion = 0
                    score = 0
                    selectedAnswer = ""
                    difficulty = null
                }) {
                    Text(text = "Перезапустить квиз")
                }
            }
        }
    }
}

@Composable
fun DifficultySelectionScreen(onDifficultySelected: (Difficulty) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Выберите сложность:")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onDifficultySelected(Difficulty.EASY) }) {
            Text(text = "Легкий")
        }
        Button(onClick = { onDifficultySelected(Difficulty.MEDIUM) }) {
            Text(text = "Нормальный")
        }
        Button(onClick = { onDifficultySelected(Difficulty.HARD) }) {
            Text(text = "Сложный")
        }
    }
}

enum class Difficulty {
    EASY, MEDIUM, HARD
}

val easyQuestions = listOf(
    Question("Какая страна самая крупная?", listOf("Китай", "Россия", "США"), "Россия"),
    Question("Какой сейчас год?", listOf("2025", "2000", "2008"), "2025"),
    Question("Какая медаль за первое место?", listOf("Бронзовая", "Серебряная", "Золотая"), "Золотая")
)

val mediumQuestions = listOf(
    Question("Сколько планет в Солнечной системе?", listOf("8", "9", "10"), "8"),
    Question("Кто написал 'Войну и мир'?", listOf("Достоевский", "Толстой", "Чехов"), "Толстой"),
    Question("Какой газ преобладает в атмосфере Земли?", listOf("Кислород", "Азот", "Углекислый газ"), "Азот")
)

val hardQuestions = listOf(
    Question("Какой элемент обозначается как 'Fe'?", listOf("Золото", "Железо", "Серебро"), "Железо"),
    Question("Кто открыл теорию относительности?", listOf("Ньютон", "Эйнштейн", "Галилей"), "Эйнштейн"),
    Question("Какой самый большой океан на Земле?", listOf("Атлантический", "Индийский", "Тихий"), "Тихий")
)

data class Question(val text: String, val options: List<String>, val correctAnswer: String)
