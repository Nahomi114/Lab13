package com.example.lab13animacion.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab13animacion.R

@Composable
fun CombinedAnimationsExample() {
    // Estados para las animaciones de tamaño, color, visibilidad y contenido
    var isExpanded by remember { mutableStateOf(false) }
    var isButtonVisible by remember { mutableStateOf(true) }
    var isDarkMode by remember { mutableStateOf(false) }

    // Tamaño y color de la "nube" animada
    val cloudSize by animateDpAsState(
        targetValue = if (isExpanded) 150.dp else 100.dp,
        animationSpec = spring(dampingRatio = 0.5f)
    )

    val cloudColor by animateColorAsState(
        targetValue = if (isDarkMode) colorResource(id = R.color.midnight_blue) else colorResource(id = R.color.sky_blue),
        animationSpec = spring()
    )

    // Color de fondo que cambia con el modo claro/oscuro
    val backgroundColor = if (isDarkMode) colorResource(id = R.color.dark_blue) else colorResource(id = R.color.light_blue)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor) // Fondo azulado de la app
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Nube animada que cambia de tamaño y color
        Box(
            modifier = Modifier
                .size(cloudSize)
                .background(cloudColor, shape = androidx.compose.foundation.shape.CircleShape) // Forma de nube (circular)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { isExpanded = !isExpanded }) {
                Text("Cambiar Nube")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón con AnimatedVisibility que se desplaza y desaparece
        AnimatedVisibility(
            visible = isButtonVisible,
            enter = slideInVertically() + fadeIn(),
            exit = slideOutVertically() + fadeOut()
        ) {
            Button(onClick = { isButtonVisible = false }) {
                Text("Desaparecer")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Transición de contenido para alternar entre "modo claro" y "modo oscuro"
        AnimatedContent(targetState = isDarkMode) { mode ->
            Text(
                text = if (mode) "Modo Oscuro" else "Modo Claro",
                fontSize = 24.sp,
                color = if (mode) Color.White else Color.Black
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón para alternar entre modos claro y oscuro
        Button(onClick = { isDarkMode = !isDarkMode }) {
            Text("Alternar Modo")
        }
    }
}

