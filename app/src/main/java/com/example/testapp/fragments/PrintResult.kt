package com.example.testapp.fragments

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.viewModels.CalcViewState

@Composable
fun PrintResult(result: Double?, onRequestCalculation: () -> Unit){
    Card(
        modifier = Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray),
        onClick = onRequestCalculation
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("Получить результат:")
                if (result != null) {
                    Text(
                        text = "$result",
                        color = Color.Black,
                        fontSize = 38.sp,
                    )
                }
                else {
                    Text(
                        text = "Dude",
                        color = Color.Black,
                        fontSize = 38.sp,
                    )
                }
            }
        }
    }
}