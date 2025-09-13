package com.example.testapp.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*

@Composable
fun NumberInputExample() {
    var text by remember { mutableStateOf("") }
    var number by remember { mutableStateOf(0) }

    Column {
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                number = newText.toIntOrNull() ?: 0 // преобразуем строку в число
            },
            label = { Text("Введите число") },
        )

        Text(text = "Вы ввели число: $number")
    }
}