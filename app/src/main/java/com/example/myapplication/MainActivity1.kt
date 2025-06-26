
package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FuelCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FuelCalculatorScreen()
                }
            }
        }
    }
}

@Composable
fun FuelCalculatorScreen() {
    var distance by remember { mutableStateOf("") }
    var consumption by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var totalFuel by remember { mutableStateOf("") }
    var totalCost by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Калькулятор расхода топлива",
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = distance,
            onValueChange = { distance = it },
            label = { Text("Дистанция (км)") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = consumption,
            onValueChange = { consumption = it },
            label = { Text("Расход топлива (л/100км)") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Цена за литр (₽)") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                try {
                    val distanceValue = distance.toDouble()
                    val consumptionValue = consumption.toDouble()
                    val priceValue = price.toDouble()

                    val fuel = (distanceValue * consumptionValue) / 100
                    val cost = fuel * priceValue

val df = DecimalFormat("#.##")
                    totalFuel = df.format(fuel)
                    totalCost = df.format(cost)
                    errorMessage = ""
                } catch (e: NumberFormatException) {
                    errorMessage = "Пожалуйста, введите корректные числа"
                    totalFuel = ""
                    totalCost = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Рассчитать")
        }

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }

        if (totalFuel.isNotEmpty()) {
            Text(
                text = "Общий объём топлива: $totalFuel л",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        if (totalCost.isNotEmpty()) {
            Text(
                text = "Стоимость поездки: $totalCost ₽",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun FuelCalculatorTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun FuelCalculatorPreview() {
    FuelCalculatorTheme {
        FuelCalculatorScreen()
    }
}
