package com.example.kebab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kebab.ui.pantallas.PantallaDetalle
import com.example.kebab.ui.pantallas.PantallaGaleria
import com.example.kebab.ui.pantallas.PantallaInicio
import com.example.kebab.ui.pantallas.PantallaSobre
import com.example.kebab.ui.theme.KebabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KebabTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets.safeDrawing
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ComidaApp()
                    }
                }
            }
        }
    }
}

@Composable
fun ComidaApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {
        composable("inicio") { PantallaInicio(navController) }
        composable("galeria") { PantallaGaleria(navController) }
        composable(
            route = "detalle/{comidaId}",
            arguments = listOf(navArgument("comidaId") { type = NavType.IntType })
        ) { backStackEntry ->
            val comidaId = backStackEntry.arguments?.getInt("comidaId") ?: 0
            PantallaDetalle(navController = navController, comidaId = comidaId)
        }
        composable("sobre") { PantallaSobre(navController) }
    }
}
