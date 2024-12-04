package de.hhn.mplab.ex1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import de.hhn.mplab.ex1.ui.theme.Mplabex1Theme
import de.hhn.mplab.ex1.ui.worldclock.screens.WorldClockScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mplabex1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WorldClockScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}