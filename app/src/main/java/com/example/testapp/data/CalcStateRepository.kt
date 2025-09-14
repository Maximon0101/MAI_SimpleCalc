package com.example.testapp.data

import com.example.testapp.models.CalcState
import kotlinx.coroutines.flow.StateFlow

interface CalcStateRepository {
    val stateFlow: StateFlow<CalcState>
    fun getCalcState(): CalcState
    fun setFirstNumber()
    fun setSecondNumber()
    fun setAction()
}