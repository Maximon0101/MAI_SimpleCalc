package com.example.testapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.models.CalcActions
import com.example.testapp.models.CalcActions.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CalcViewModel : ViewModel() {

    private val _stateFlow: MutableStateFlow<CalcViewState> = MutableStateFlow(
        CalcViewState(
            0,
            0,
            CalcActions.Plus,
            0.0
        )
    )
    val stateFlow: StateFlow<CalcViewState> = _stateFlow

    fun updateFirstNumber(newNumber: Int) {
        val newState = _stateFlow.value.copy(firstNumber = newNumber)
        _stateFlow.value = newState
    }

    fun updateSecondNumber(newNumber: Int) {
        val newState = _stateFlow.value.copy(secondNumber = newNumber)
        _stateFlow.value = newState
    }

    fun updateAction(newAction: CalcActions) {
        val newState = _stateFlow.value.copy(action = newAction)
        _stateFlow.value = newState
    }

    suspend fun calculateResult(): Double? {
        val currentState = _stateFlow.value
        return (when (currentState.action) {
            Plus -> (currentState.firstNumber + currentState.secondNumber).toDouble()
            Minus -> (currentState.firstNumber - currentState.secondNumber).toDouble()
            Multiply -> (currentState.firstNumber * currentState.secondNumber).toDouble()
            Divide -> if (currentState.secondNumber == 0) {
                return null
            } else return (currentState.firstNumber / currentState.secondNumber).toDouble() //TODO: test divide by 0
        })
    }

    fun requestRecalculation() {
        viewModelScope.launch {
            val newState = _stateFlow.value.copy(result = calculateResult())
            _stateFlow.value = newState
        }
    }
}