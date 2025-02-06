package com.example.top_academy_lab1.ui.theme.weeks

import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


//Вычислить сумму квадратов числа от 1 до N, где N - введенное число пользователя
//8 задание
@Preview
@Composable
fun Task4() {
    @Composable
    fun Task7() {
        val context = LocalContext.current
        var stroke by remember { mutableStateOf("321test123") }
        var char = ""
        var old by remember { mutableStateOf("") }
        var result by remember { mutableStateOf("") }
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                Text("Задание номер 8")
                Text("Начальная строка: $stroke")
                Text("Введите индекс элемента ")
                TextField(
                    value = old,
                    onValueChange = { newText ->
                        if (newText.length < 2) {
                            old = newText
                            char = old
                        }
                    },
                )
                Text("Введите элемент для замены")
                TextField(
                    value = result,
                    onValueChange = { newText ->
                        if (newText.length < 2) {
                            result = newText
                            stroke = stroke.replaceRange(char.toInt(), char.toInt() + 1, result)
                        }
                    },
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("Измененная строка: $stroke")
            }
        }
    }}