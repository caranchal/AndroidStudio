package com.example.top_academy_lab1.ui.theme.weeks

import android.util.Log
import android.widget.Space
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
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
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

@Composable
fun Task4() {
    val context = LocalContext.current
    var inputString by remember { mutableStateOf("") }
    var sum by remember{ mutableIntStateOf(0) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            Text("Задание номер 4")
            Text("Введите число:")
            TextField(
                value = inputString,
                onValueChange = { newText ->
                    inputString = newText
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Button(
                onClick = {
                    val n = inputString.toInt()

                    //var sum = 0

                    for (i in 1..n) {
                        sum += i * i
                    }

                    Log.d("Result", "Summ: $sum")
                    println("Summ: $sum")

                    //val toast = Toast.makeText(context, "Сумма квадратов: $sum", LENGTH_SHORT)
                    //toast.show()
                },
            ) {
                Text("Вычислить сумму квадратов")
            }
            if (sum > 0)
                Text("Сумма квадратов: $sum")

            for (i in 1..10) {
                Text("Hello world")
            }
        }
    }
}

//Вычислить 1/1! + 1/3! + 1/5! +...
//Проводить вычисления до того момента когда новый суммируемый элемент будет меньше какого то малого значения

@Composable
fun Task5() {
    val context = LocalContext.current
    var sum by remember{ mutableFloatStateOf(0f) }
    val e = 0.0000001




    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            Text("Задание номер 5")

            Spacer(modifier = Modifier.height(16.dp))

            var counter = 1
            var current = 1.0f/factorial(counter).toFloat()
            //sum += current
            sum = current

            while(current > e){
                counter += 2
                current = 1.0f/factorial(counter).toFloat()
                sum += current
            }

            Text("Посчитанная сумма: $sum")
            Text("current: $current")
            Text("counter: $counter")
        }
    }
}

fun factorial(a: Int): Int{
    if (a == 1) return 1
    return a*factorial(a-1)
}

//Задание 6. В заданной строке подсчитать количество не цифр.

@Composable
fun Task6() {
    val context = LocalContext.current
    val stroke = "321test123"
    var sumOfLetters = countOfLetters(stroke)



    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            Text("Задание номер 6")

            Spacer(modifier = Modifier.height(16.dp))

            Text("Начальная строка: $stroke")
            Text("Количество букв: $sumOfLetters")
        }
    }
}

fun countOfLetters(stroke: String): Int{
    var sum = 0

    for (char in stroke){
        if (char.isLetter()){
            sum += 1
        }
    }

    /*
    for(i in 0..stroke.length){
        if (stroke[i].isLetter())
            sum+=1
    }
    */

    /*
    stroke.forEach { symbol -> if (symbol.isLetter()) { sum += 1 } }
    stroke.forEachIndexed() { index,symbol -> if (symbol.isLetter()) {
        sum += 1
        println(index)
    } }
    */

    return sum
}

//Задание 7. В заданной строке определить номер последнего символа, равного заданному символу.
// Символ необходимо считать у пользователя

@Composable
fun Task7() {
    val context = LocalContext.current
    val stroke = "321test123"

    var inputString by remember { mutableStateOf("") }
    var index by remember { mutableIntStateOf(0) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            Text("Задание номер 7")

            Text("Начальная строка: $stroke")

            TextField(
                value = inputString,
                onValueChange = { newText ->
                    if (newText.length <= 1){
                        inputString = newText

                        if (inputString.isNotEmpty()){
                            var lastIndex = 0

                            stroke.forEachIndexed() { index,symbol -> if (symbol == inputString[0]) {
                                lastIndex = index
                            } }

                            index = lastIndex
                        }
                    }
                },
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Начальная строка: $stroke")
            Text("Индекс элемента $inputString = $index")

        }
    }
}



//Задание 8. Дана строка. Заменить в ней указанный символ другим. Символы ввести с клавиатуры.
@Composable
fun Task8() {

}