package com.example.testapp.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun NumberInput(number: Int, onNumberChange: (Int) -> Unit) {
    val keyboardOption = remember { KeyboardOptions(keyboardType = KeyboardType.Number) }

    Column {
        OutlinedTextField(
            value = number.toString(),
            onValueChange = { newText ->
                if (newText.isEmpty()) { onNumberChange(0) }
                val newNumber = newText.toIntOrNull() ?: return@OutlinedTextField // преобразуем строку в число
                onNumberChange(newNumber)
            },
            label = { Text("Введите число") },
            keyboardOptions = keyboardOption
        )

        Text(text = "Вы ввели число: $number")
    }
}