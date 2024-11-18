package com.example.lab13animacion.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedSizePositionExample() {
    // Estado para controlar el tamaño y la posición
    var isExpanded by remember { mutableStateOf(false) }

    // Tamaño animado
    val boxSize by animateDpAsState(targetValue = if (isExpanded) 150.dp else 100.dp)

    // Offset animado
    val boxOffset by animateDpAsState(targetValue = if (isExpanded) 50.dp else 0.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Size
        Button(onClick = { isExpanded = !isExpanded }) {
            Text(text = "Move and change size")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Animation
        Box(
            modifier = Modifier
                .size(boxSize)                        // Controla el tamaño animado
                .offset(x = boxOffset, y = boxOffset) // Controla el offset animado
                .background(Color.Green)
        )
    }
}
