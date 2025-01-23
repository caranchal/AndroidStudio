@file:Suppress("UNREACHABLE_CODE")

package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task10()




        }
    }
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@SuppressLint("ShowToast")
@Composable
fun Task1(LENGHT_SHORT: Int) {
    MyApplicationTheme {
        val context = LocalContext.current
        var inputString by remember {mutableStateOf("")}
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column ( modifier = Modifier.padding(innerPadding).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center ){
                Text("test1")
                TextField(
                    value = inputString,
                    onValueChange = {
                        newtext ->
                        if(newtext.length <= 1){
                            inputString = newtext
                            if(inputString.lowercase().contains('d')){
                                val toast = Toast.makeText(context, "это дуб", LENGHT_SHORT)
                                toast.show()
                            }
                    }
                    }
                )

            }
        }
        }
    }
@SuppressLint("ShowToast")
@Composable
fun Task2(LENGHT_SHORT: Int) {
    MyApplicationTheme {
        val context = LocalContext.current
        var inputString by remember {mutableStateOf("")}
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column ( modifier = Modifier.padding(innerPadding).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center ){
                Text("test1")
                TextField(
                    value = inputString,
                    keyboardOptions = KeyboardOptions ( KeyboardType = KeyboardType.Number),
                    onValueChange = {
                            newtext ->
                        if(newtext.length <= 1 ) {
                            inputString = newtext
                            inputString.lowercase()
                            Log.d("test", inputString)
                            if (inputString != "") {
                                val toast = Toast.makeText(
                                    context,
                                    getDayOfTheWeek(inputString.lowercase()),
                                    LENGHT_SHORT
                                )
                                toast.show()
                            }
                        }
                    }
                )

            }
        }
    }
}
fun getDayOfTheWeek(dayNumber:String):String{
    return when (dayNumber){
        "1"-> "понедельник"
        "2"-> "понедельник"
        "3"-> "понедельник"
        "4"-> "понедельник"
        "5"-> "понедельник"
        "6"-> "понедельник"
        "7"-> "понедельник"
        else->
            "ошибка"

    }
@Composable
    fun Task3() {
        MyApplicationTheme {
            val context = LocalContext.current
            var inputString by remember {mutableStateOf("")}
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Column ( modifier = Modifier.padding(innerPadding).fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                    {
                    Text("test1")
                    TextField(
                        value = inputString,
                        keyboardOptions = KeyboardOptions ( KeyboardType = KeyboardType.Number),
                        onValueChange = {
                                newtext ->
                            if(newtext.length <= 1 ) {
                                inputString = newtext
                                inputString.lowercase()
                                Log.d("test", inputString)
                                if (inputString != "") {
                                    val toast = Toast.makeText(
                                        context,
                                        getDayOfTheWeek(inputString.lowercase()),
                                        LENGHT_SHORT
                                    )
                                    toast.show()
                                }
                            }
                        }
                    )

                }
            }
        }
    }
    fun getDayOfTheWeek(dayNumber:String):String{
        return when (dayNumber){
            "1"-> "понедельник"
            "2"-> "понедельник"
            "3"-> "понедельник"
            "4"-> "понедельник"
            "5"-> "понедельник"
            "6"-> "понедельник"
            "7"-> "понедельник"
            else->
                "ошибка"

        }
}


    @Composable

    fun Task5() {
        MyApplicationTheme {
            val context = LocalContext.current
            var inputString by remember {mutableStateOf("")}
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Column ( modifier = Modifier.padding(innerPadding).fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center ){
                    Text("test1")
                    TextField(
                        value = inputString,
                        keyboardOptions = KeyboardOptions ( KeyboardType = KeyboardType.Number),
                        onValueChange = {
                                newtext ->
                            if(newtext.length <= 1 ) {
                                inputString = newtext
                                inputString.lowercase()
                                Log.d("test", inputString)
                                if (inputString != "") {
                                    val toast = Toast.makeText(
                                        context,
                                        getDayOfTheMonth(inputString.lowercase()),
                                        LENGHT_SHORT
                                    )
                                    toast.show()
                                }
                            }
                        }
                    )

                }
            }
        }
    }
    fun getDayOfTheMonth(monthNumber:String):String{
        return when (monthNumber){
            "1"-> "зима"
            "2"-> "весна"
            "3"-> "лето"
            "4"-> "осень"
            else->
                "ошибка"

        }
    }
}


//Вариант 3. Площадь ромба можно вычислить двумя способами:
// 1) по высоте и стороне S=ah;
//2) по диагоналям S=(d1*d2)/2.
//Вычислить площадь ромба по номеру варианта решения.
*/
/*@Composable
fun Task0() {
    MyApplicationTheme {
        val context = LocalContext.current //Контекст, используется для Toast (всплывающе окна)
        var a by remember { mutableStateOf("") } //Умная переменная
        var b by remember { mutableStateOf("") }
        var c by remember { mutableStateOf("") }

        var result1 by remember { mutableStateOf("") }




        Scaffold(modifier = Modifier.fillMaxSize()) {  innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text("Задание номер 0")
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "среднее арифметическое $result1"
                )


                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = a,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), //Настройка клавиатуры на ввод только чисел
                    onValueChange = {
                            newText ->
                        a = newText
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = b,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), //Настройка клавиатуры на ввод только чисел
                    onValueChange = {
                            newText ->

                        b = newText
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = c,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), //Настройка клавиатуры на ввод только чисел
                    onValueChange = {
                            newText ->
                        c = newText
                    }
                )


                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = {
                    result1 = makeFormula1(a,b,c)

                }) { Text("Рассчитать") }
            }

        }
    }
}

fun makeFormula1(a: String, b: String,c:String ): String{
    val int_a = a.toIntOrNull() ?: 0
    val int_b = b.toIntOrNull() ?: 0
    val int_c = c.toIntOrNull() ?: 0
    val S = (int_a + int_b + int_c) / 3
    return "$S"
}
*/

@Composable
fun Task10() {
    MyApplicationTheme {
        val context = LocalContext.current //Контекст, используется для Toast (всплывающе окна)
        var a by remember { mutableStateOf("") } //Умная переменная


        var result1 by remember { mutableStateOf("") }




        Scaffold(modifier = Modifier.fillMaxSize()) {  innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text("Задание номер 10")
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "введите что нибудь $result1"
                )


                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = a,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), //Настройка клавиатуры на ввод только чисел
                    onValueChange = {
                            newText ->
                        a = newText
                    }
                )






                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = {
                    result1 = makeFormula1(a)

                }) { Text("Рассчитать") }
            }

        }
    }
}

fun makeFormula1(a: String): String{
    return when(a){
        "0"->"это цифра"
        "1"->"это цифра"
        "2"->"это цифра"
        "3"->"это цифра"
        "4"->"это цифра"
        "5"->"это цифра"
        "6"->"это цифра"
        "7"->"это цифра"
        "8"->"это цифра"
        "9"->"это цифра"
        "&"->"это спец символ"
        "#"->"это спец символ"
        else
            ->"непредусмотреный вариант"
}
}