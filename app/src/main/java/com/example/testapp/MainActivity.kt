package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testapp.fragments.ChooseActionMenu
import com.example.testapp.fragments.NumberInput
import com.example.testapp.fragments.PrintResult
import com.example.testapp.viewModels.CalcViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CalcViewModel = viewModel<CalcViewModel>()
            val viewState by viewModel.stateFlow.collectAsState()

            Box(
                modifier = Modifier
                    .padding(8.dp),
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.aboba),
                        contentDescription = null
                    )
                    NumberInput(viewState.firstNumber, { viewModel.updateFirstNumber(it) })
                    ChooseActionMenu(viewState.action, { viewModel.updateAction(it) })
                    NumberInput(viewState.secondNumber, { viewModel.updateSecondNumber(it) })
                    PrintResult(viewState.result, { viewModel.requestRecalculation() })
                }
            }
        }
    }
}





