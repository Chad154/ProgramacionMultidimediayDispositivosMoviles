package com.example.fotoencimatexto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fotoencimatexto.ui.theme.FotoEncimaTextoTheme
//Para que funcione los offset con RememberSaveable
val OffsetSaver = Saver<Offset,Pair<Float,Float>>(
    save = { Pair(it.x,it.y)}, //Guardar como pares de float
    restore = {(x,y) -> Offset(x,y)} //Restaurar a Offset
    )

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FotoEncimaTextoTheme {
                foto()
            }
        }
    }
}

@Composable
fun foto() {

    // Color → NO es saveable
   // var colorFondo by remember { mutableStateOf(Color.Yellow) }
    var colorFondoInt by rememberSaveable { mutableStateOf(Color.Yellow.toArgb()) }
    var colorFondo = Color(colorFondoInt)
    // Offset → NO es saveable
    var posicionTexto by rememberSaveable (stateSaver = OffsetSaver){ mutableStateOf(Offset.Zero) }

    // Estos sí son saveables
    var anchoPantalla by rememberSaveable { mutableStateOf(0f) }
    var altoPantalla by rememberSaveable { mutableStateOf(0f) }
    var anchoTexto by rememberSaveable { mutableStateOf(0f) }
    var altoTexto by rememberSaveable { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(colorFondo)
            .onGloballyPositioned { coordinates ->
                altoPantalla = coordinates.size.height.toFloat()
                anchoPantalla = coordinates.size.width.toFloat()
            }
    ) {
        // Imagen interactiva
        imagenInteractiva()

        // El texto arrastrable
        Text(
            text = "Jamones",
            color = Color.Yellow,
            fontSize = 75.sp,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    altoTexto = coordinates.size.height.toFloat()
                    anchoTexto = coordinates.size.width.toFloat()

                    // Primera vez: centrar
                    if (posicionTexto == Offset.Zero) {
                        posicionTexto = Offset(
                            (anchoPantalla - anchoTexto) / 2,
                            (altoPantalla - altoTexto) / 2
                        )
                    }
                }
                .offset {
                    IntOffset(
                        posicionTexto.x.toInt(),
                        posicionTexto.y.toInt()
                    )
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        posicionTexto = Offset(
                            posicionTexto.x + dragAmount.x,
                            posicionTexto.y + dragAmount.y
                        )
                    }
                }
        )

        // Botón cambiar fondo
        Button(
            onClick = { colorFondoInt = colorAleatorio().toArgb() },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text(text = "Cambiar Fondo")
        }
    }
}

// GENERA UN COLOR ALEATORIO
fun colorAleatorio(): Color {
    val r = kotlin.random.Random.nextFloat()
    val g = kotlin.random.Random.nextFloat()
    val b = kotlin.random.Random.nextFloat()
    return Color(r, g, b)
}

@Composable
fun imagenInteractiva() {

    // Estos no pueden ser saveables
    var escala by remember { mutableStateOf(1f) }
    var posicion by remember { mutableStateOf(Offset.Zero) }
    var rotacion by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { _, desplazamiento, zoom, rotacionAngulo ->
                    posicion += desplazamiento
                    escala *= zoom
                    rotacion += rotacionAngulo
                }
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        escala = 1f
                        posicion = Offset.Zero
                        rotacion = 0f
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.jamon),
            contentDescription = "Imagen del jamon de Imad",
            modifier = Modifier.graphicsLayer(
                translationX = posicion.x,
                translationY = posicion.y,
                scaleX = escala.coerceIn(0.5f, 3f),
                scaleY = escala.coerceIn(0.5f, 3f),
                rotationZ = rotacion
            )
        )
    }
}
