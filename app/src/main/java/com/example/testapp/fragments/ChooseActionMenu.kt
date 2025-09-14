package com.example.testapp.fragments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.testapp.models.CalcActions
import compose.icons.FeatherIcons
import compose.icons.feathericons.Divide
import compose.icons.feathericons.Minus
import compose.icons.feathericons.Plus
import compose.icons.feathericons.X

@Composable
fun ChooseActionMenu(currentAction: CalcActions, onActionChange: (CalcActions) -> Unit){
    Box(
        modifier = Modifier,
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("$currentAction")
            MinimalDropdownMenu(onActionChange)
        }
    }
}

@Composable
fun MinimalDropdownMenu(onActionChange: (CalcActions) -> Unit  ) {
    var expanded by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier,
    ) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(Icons.Default.ArrowDropDown, contentDescription = "More options")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                leadingIcon = { Icon(
                    imageVector = FeatherIcons.Plus,
                    modifier = Modifier,
                    contentDescription = null,) },
                text = { Text("") },
                onClick = { onActionChange(CalcActions.Plus) }
            )
            DropdownMenuItem(
                leadingIcon = { Icon(
                    imageVector = FeatherIcons.Minus,
                    modifier = Modifier,
                    contentDescription = null,
                ) },
                text = { Text("") },
                onClick = { onActionChange(CalcActions.Minus) }
            )
            DropdownMenuItem(
                leadingIcon = { Icon(
                    imageVector = FeatherIcons.X,
                    modifier = Modifier,
                    contentDescription = null,) },
                text = { Text("") },
                onClick = { onActionChange(CalcActions.Multiply) }
            )
            DropdownMenuItem(
                leadingIcon = { Icon(
                    imageVector = FeatherIcons.Divide,
                    modifier = Modifier,
                    contentDescription = null,
                ) },
                text = { Text("") },
                onClick = { onActionChange(CalcActions.Divide) }
            )
        }
    }
}
