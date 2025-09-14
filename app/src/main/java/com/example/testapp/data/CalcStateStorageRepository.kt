package com.example.testapp.data

import com.example.testapp.models.CalcActions
import com.example.testapp.models.CalcState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalcStateStorageRepository : CalcStateRepository {
    val _stateFlow = MutableStateFlow(CalcState(0, 0, CalcActions.Plus))

    override val stateFlow: StateFlow<CalcState> = _stateFlow

    override fun getLastCalcState(): CalcState {
        TODO("Not yet implemented")
    }

    override fun setFirstNumber() {
        TODO("Not yet implemented")
    }

    override fun setSecondNumber() {
        TODO("Not yet implemented")
    }

    override fun setAction() {
        TODO("Not yet implemented")
    }

    private fun getStateFromStorage(): CalcState {
        TODO("Not yet implemented")
    }

}