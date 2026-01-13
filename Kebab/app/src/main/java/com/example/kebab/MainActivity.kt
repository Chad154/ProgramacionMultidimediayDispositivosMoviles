package com.example.kebab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kebab.ui.pantallas.PantallaInicio
import com.example.kebab.ui.theme.KebabTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KebabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPading ->
                    ComidaApp()
                    Modifier.padding(innerPading)

                }
            }
        }
    }
}

@Composable
fun ComidaApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Inicio"){
        composable("Inicio") { PantallaInicio(navController) }
    }
}


/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KebabTheme {
        Greeting("Android")
    }
}

 */