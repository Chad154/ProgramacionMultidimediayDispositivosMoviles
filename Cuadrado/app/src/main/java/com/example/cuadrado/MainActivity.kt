package com.example.cuadrado

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import model.Cuadrado
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Identificación de la vista
        val cuadradoView: View = findViewById(R.id.cuadrado)

        // Identificación de botones
        val botonArriba: Button = findViewById(R.id.buttonArriba)
        val botonAbajo: Button = findViewById(R.id.buttonAbajo)
        val botonDerecha: Button = findViewById(R.id.buttonDerecha)
        val botonIzquierda: Button = findViewById(R.id.buttonIzquierda)
        val botonCambiarTamanio: Button = findViewById(R.id.buttonCambiarTamanio)
        val botonCambiarColor: Button = findViewById(R.id.buttonCambiarColor)
        val botonCambiarTamanioMenor: Button = findViewById(R.id.buttonCambiarTamanioMenor)

        // Esperar a que la vista esté lista (ya tiene ancho y alto)
        cuadradoView.post {
            val inicialAncho = cuadradoView.width
            val inicialAlto = cuadradoView.height
            val inicialX = cuadradoView.x.toInt()
            val inicialY = cuadradoView.y.toInt()

            // Asociar la vista con el objeto cuadrado
            val cuadrado = Cuadrado(
                ContextCompat.getColor(this, R.color.red),
                inicialAncho,
                inicialAlto
            ).apply {
                x = inicialX
                y = inicialY
            }

            // Poner los botones a la escucha
            botonArriba.setOnClickListener {
                cuadrado.moverArriba()
                actualizarVista(cuadrado, cuadradoView)
            }

            botonAbajo.setOnClickListener {
                cuadrado.moverAbajo()
                actualizarVista(cuadrado, cuadradoView)
            }

            botonIzquierda.setOnClickListener {
                cuadrado.moverIzquierda()
                actualizarVista(cuadrado, cuadradoView)
            }

            botonDerecha.setOnClickListener {
                cuadrado.moverDerecha()
                actualizarVista(cuadrado, cuadradoView)
            }

            botonCambiarTamanio.setOnClickListener {
                if (cuadrado.ancho <= 500 && cuadrado.alto <= 500)
                    cuadrado.cambiarTamanio(cuadrado.ancho + 10, cuadrado.alto + 10)
                actualizarVista(cuadrado, cuadradoView)
            }

            botonCambiarTamanioMenor.setOnClickListener {
                if (cuadrado.ancho >= 100 && cuadrado.alto >= 100)
                    cuadrado.cambiarTamanio(cuadrado.ancho - 10, cuadrado.alto - 10)
                actualizarVista(cuadrado, cuadradoView)
            }

            botonCambiarColor.setOnClickListener {
                cuadrado.color = generarColorAleatorio()
                actualizarVista(cuadrado, cuadradoView)
            }
        }
    }

    private fun actualizarVista(cuadrado: Cuadrado, cuadradoView: View) {
        cuadradoView.layoutParams.width = cuadrado.ancho
        cuadradoView.layoutParams.height = cuadrado.alto
        cuadradoView.setBackgroundColor(cuadrado.color)
        cuadradoView.x = cuadrado.x.toFloat()
        cuadradoView.y = cuadrado.y.toFloat()
        cuadradoView.requestLayout()
    }

    private fun generarColorAleatorio(): Int {
        val random = Random.Default
        val rojo = random.nextInt(256)
        val verde = random.nextInt(256)
        val azul = random.nextInt(256)
        return Color.rgb(rojo, verde, azul)
    }
}
