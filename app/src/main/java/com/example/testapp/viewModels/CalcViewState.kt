package com.example.testapp.viewModels

import com.example.testapp.models.CalcActions

data class CalcViewState (
    val firstNumber: Int,
    val secondNumber: Int,
    val action: CalcActions,
    val result: Double,
)