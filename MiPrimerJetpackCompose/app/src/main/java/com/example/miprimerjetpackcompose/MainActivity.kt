package com.example.miprimerjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miprimerjetpackcompose.ui.theme.MiPrimerJetpackComposeTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           //MiprimeraComposable()
                }
            }
        }

//@Preview(showBackground = true, name = "Primera")
@Composable
fun MiprimeraComposable(){
    Row(modifier = Modifier.fillMaxSize().padding(top = 40.dp)) {
        Text(text = "Primera fila")

        Text(text = "SegundaFila")
        Column(modifier = Modifier.fillMaxSize().padding(top = 40.dp)) {
            Text(text = "Esta es mi primera funcion")
            Text(text = "Aqui escribimos mi segunda linea")
        }
    }
}

@Composable
fun MiSegundaComposable(){
    Box(modifier = Modifier.fillMaxSize().padding(20.dp), contentAlignment = Alignment.Center){
        Text(text = "Pepito", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "Antonio Garcia",modifier = Modifier.align(Alignment.Center))
        Text(text = "Tomas",modifier = Modifier.align(Alignment.BottomEnd))
        Text(text = "Antonio Garcia",modifier = Modifier.align(Alignment.BottomStart))
        Text(text = "Antonio Garcia",modifier = Modifier.align(Alignment.BottomCenter))

    }
}

@Preview(showBackground = true, name = "Segunda")
@Composable
fun MisegundaComposablePreview(){
    MiSegundaComposable()
}

