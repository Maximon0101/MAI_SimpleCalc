package com.example.testapp.fragments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import compose.icons.FeatherIcons
import compose.icons.feathericons.Divide
import compose.icons.feathericons.Minus
import compose.icons.feathericons.Plus
import compose.icons.feathericons.X

@Composable
fun ChooseActionMenu(){
    Box(
        modifier = Modifier,
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Выберете действие:")
            MinimalDropdownMenu()
        }
    }
}

@Composable
fun MinimalDropdownMenu() {
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
                onClick = { /* Do something... */ }
            )
            DropdownMenuItem(
                leadingIcon = { Icon(
                    imageVector = FeatherIcons.Minus,
                    modifier = Modifier,
                    contentDescription = null,
                ) },
                text = { Text("") },
                onClick = { /* Do something... */ }
            )
            DropdownMenuItem(
                leadingIcon = { Icon(
                    imageVector = FeatherIcons.X,
                    modifier = Modifier,
                    contentDescription = null,) },
                text = { Text("") },
                onClick = { /* Do something... */ }
            )
            DropdownMenuItem(
                leadingIcon = { Icon(
                    imageVector = FeatherIcons.Divide,
                    modifier = Modifier,
                    contentDescription = null,
                ) },
                text = { Text("") },
                onClick = { /* Do something... */ }
            )
        }
    }
}
