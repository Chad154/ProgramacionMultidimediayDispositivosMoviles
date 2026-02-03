package com.example.kebab.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kebab.data.Comida

@Composable
fun PantallaDetalle(navController: NavController, comidaId: Int) {
    val comida = Comida.RepositorioComida.getComidaById(comidaId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (comida == null) {
            Text("No se encontró la comida (id=$comidaId)")
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("Volver")
            }
            return
        }

        Text(text = comida.nombre, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        Image(
            painter = painterResource(id = comida.imagen),
            contentDescription = comida.nombre,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = comida.descripcion, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}
