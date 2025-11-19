package com.example.fotoencimatexto


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fotoencimatexto.ui.theme.FotoEncimaTextoTheme

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

//@Preview (showBackground = true, widthDp = 100, heightDp = 100)
@Composable
fun texto() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Jamones Imad", color = Color.Black, fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun foto() {
    //Declaramos una variable observable para almacenar el color de fondo
    //val colorFondo = remember {mutableStateOf(Color.White)}
    var colorFondo by remember { mutableStateOf(Color.Yellow) }
    var posicionTexto by remember { mutableStateOf(Offset(0f, 0f)) }
    //Calculamos el alto y ancho de la pantalla
    var anchoPantalla by remember { mutableStateOf(0f) }
    var altoPantalla by remember { mutableStateOf(0f) }
    //Calculamos el alto y el ancho del texto
    var anchoTexto by remember { mutableStateOf(0f) }
    var altoTexto by remember { mutableStateOf(0f) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(colorFondo)
            .onGloballyPositioned { coordinates ->
                altoPantalla = coordinates.size.height.toFloat()
                anchoPantalla = coordinates.size.width.toFloat()
                //if (posicionTexto.x==0 && posicionTexto.y==0)
            }

    ) {
        /*Image(
            painter = painterResource(id = R.drawable.jamon),
            contentDescription = "Imagen del jamon de Imad",
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()

        )*/

        imagenInteractiva(

        )



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
                    if (posicionTexto == Offset(0f, 0f)) {
                        posicionTexto = Offset(
                            (anchoPantalla - anchoTexto) / 2, (altoPantalla - altoTexto) / 2
                        )
                    }
                }
                .offset { IntOffset(posicionTexto.x.toInt(), posicionTexto.y.toInt()) }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume() // Indica que manejas el gesto
                        posicionTexto = Offset(
                            posicionTexto.x + dragAmount.x, posicionTexto.y + dragAmount.y
                        )
                    }

                }

        )

        Button(
            onClick = { colorFondo = colorAleatorio() },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text(text = "Cambiar Fondo")

        }
    }
}

fun colorAleatorio(): Color {
    val rojo = kotlin.random.Random.nextFloat()
    //val rojoNuevo = (0..255).random().toFloat()
    val verde = kotlin.random.Random.nextFloat()
    //val verdeNuevo = (0..255).random().toFloat()
    val azul = kotlin.random.Random.nextFloat()
    //val azulNuevo = (0..255).random().toFloat()
    //return Color(rojoNuevo, verdeNuevo,azulNuevo)
    return Color(rojo, verde, azul)
}

@Composable
fun imagenInteractiva() {
    //Almacenar y observar la escala de la imagen
    var escala by remember { mutableStateOf(1f) }
    //necesitamos la posicion de la imagen
    var posicion by remember { mutableStateOf(Offset.Zero) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { _, desplazamiento, zoom, _ ->
                    //aplicamos el desplazamiento a la posicion
                    posicion += desplazamiento
                    //aplicamos el zoom a la escala
                    escala *= zoom
                }

            },
        contentAlignment = Alignment.Center
    )
    {
        Image(
            painter = painterResource(id = R.drawable.jamon),
            contentDescription = "Imagen del jamon de Imad",
            modifier = Modifier
                //graphicsLayer permite aplicar una escala y una posicion a la imagen
                .graphicsLayer(
                    translationX = posicion.x,
                    translationY = posicion.y,
                    //Escala
                    scaleX = escala.coerceIn(0.5f,3f), //Limite del zoom por el eje X
                    scaleY = escala.coerceIn(0.5f,3f) //Limite del zoom por eje Y
                )

        )
    }
}



