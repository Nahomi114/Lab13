package com.example.lab13animacion.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Define los estados de la interfaz
enum class ScreenState { Cargando, Contenido, Error }

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentExample() {
    // Estado para controlar el estado actual de la pantalla
    var currentState by remember { mutableStateOf(ScreenState.Cargando) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // AnimatedContent para hacer la transición entre estados
        AnimatedContent(
            targetState = currentState,
            transitionSpec = { fadeIn() with fadeOut() }, label = "" // Efectos de entrada y salida
        ) { state ->
            when (state) {
                ScreenState.Cargando -> Text(text = "Cargando Contenido.....", modifier = Modifier.padding(16.dp))
                ScreenState.Contenido -> Text(text = "Contenido Cargado", modifier = Modifier.padding(16.dp))
                ScreenState.Error -> Text(text = "Error en carga de contenido", modifier = Modifier.padding(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botones para cambiar el estado
        Row {
            Button(onClick = { currentState = ScreenState.Cargando }) {
                Text("Cargando")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { currentState = ScreenState.Contenido }) {
                Text("Contenido")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { currentState = ScreenState.Error }) {
                Text("Error")
            }
        }
    }
}
