package com.example.lab13animacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.lab13animacion.screens.AnimatedColorExample
import com.example.lab13animacion.screens.AnimatedContentExample
import com.example.lab13animacion.screens.AnimatedSizePositionExample
import com.example.lab13animacion.screens.CombinedAnimationsExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    // AnimatedVisibilityExample() // Llamada a la función de ejemplo
                    // AnimatedColorExample()
                    // AnimatedSizePositionExample()
                    // AnimatedContentExample()
                    CombinedAnimationsExample()
                }
            }
        }
    }
}
