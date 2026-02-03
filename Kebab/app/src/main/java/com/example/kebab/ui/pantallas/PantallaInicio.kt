package com.example.kebab.ui.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kebab.ui.theme.KebabTheme

@Composable
fun PantallaInicio(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido al altar al Kebab")

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigate("galeria") }) {
            Text("Ver galería")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("sobre") }) {
            Text("Sobre la app")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicioPreview() {
    KebabTheme {
        val navController = rememberNavController()
        PantallaInicio(navController = navController)
    }
}
