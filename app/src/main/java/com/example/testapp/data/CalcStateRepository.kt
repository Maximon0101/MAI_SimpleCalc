package com.example.testapp.data

import com.example.testapp.models.CalcActions
import com.example.testapp.models.CalcState
import kotlinx.coroutines.flow.StateFlow

interface CalcStateRepository {
    val stateFlow: StateFlow<CalcState>
    fun getLastCalcState(): CalcState
    fun setFirstNumber(number: Int)
    fun setSecondNumber(number: Int)
    fun setAction(action: CalcActions)
}