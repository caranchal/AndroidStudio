package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material3.Text as Text1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CompetitionResults(participants: List<String>) {
    Column {
        participants.take(5).forEachIndexed { index, surname ->
            ParticipantCard(place = index + 1, surname = surname)
        }
    }
}

@Composable
fun ParticipantCard(place: Int, surname: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text1(text = "$place место")
            Text1(text = surname)
        }
    }
}
@Composable
fun Screen() {
    val participants = listOf("Пальма", "Петров", "Иванов", "моргенштер", "шершень", "Смирнов")
    CompetitionResults(participants = participants)
}
@Composable
fun EvenNumbersList() {
    var numbers by remember { mutableStateOf((0 until 200 step 2).toList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        numbers.forEachIndexed { index, number ->
            Button(
                onClick = {
                    numbers = numbers.toMutableList().apply { removeAt(index) }
                    },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp))
                    {
                        Text1(text = number.toString())
                    }
        }
    }
}
@Composable
fun EvenNumbersLazyList() {

    var numbers by remember { mutableStateOf((0 until 200 step 2).toList()) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        itemsIndexed(numbers) { index, number ->
            Button(onClick = {

                    numbers = numbers.toMutableList().apply { removeAt(index) }
                }, modifier = Modifier
            .fillMaxWidth()
                    .padding(vertical = 4.dp))
                    {
                        Text1(text = number.toString())
                    }

        }
    }
}
@Composable
fun screen1(){
    EvenNumbersList()

}
@Composable
fun screen2(){
    EvenNumbersLazyList()
}
