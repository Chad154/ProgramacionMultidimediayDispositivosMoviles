package com.example.cuadrado

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Cuadrado

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //identificacion de la vista
        val cuadradoView: View = findViewById(R.id.cuadrado)

        //asociar la bista con el objeto cuadrado
        val cuadrado: Cuadrado =
            Cuadrado(ContextCompat.getColor(this, R.color.red), ancho = 100, alto = 100)

        //identificacionde botones
        val botonArriba: Button = findViewById(R.id.buttonArriba)
        val botonAbajo: Button = findViewById(R.id.buttonAbajo)
        val botonDerecha: Button = findViewById(R.id.buttonDerecha)
        val botonIzquierda: Button = findViewById(R.id.buttonIzquierda)
        val botonCambiarTamanio: Button = findViewById(R.id.buttonCambiarTamanio)
        val botonCambiarColor: Button = findViewById(R.id.buttonCambiarColor)

        //ponemos los botones a la escucha
        botonArriba.setOnClickListener {
            cuadrado.moverArriba()
        }

        botonAbajo.setOnClickListener {
            cuadrado.moverAbajo()
        }

        botonIzquierda.setOnClickListener {
            cuadrado.moverIzquierda()
        }

        botonDerecha.setOnClickListener {
            cuadrado.moverDerecha()
        }

        botonCambiarTamanio.setOnClickListener {
            cuadrado.cambiarTamanio(150, 150)
        }

        botonCambiarColor.setOnClickListener {
            cuadrado.color = ContextCompat.getColor(this, R.color.blue)

        }
    }

    private fun actualizarVista(cuadrado: Cuadrado, cuadradoView: View) {
        //Aqui es donde enlazamos la vista con el objeto
//la vista actualizara su ancho y alto con los datos del objeto
        cuadradoView.layoutParams.width = cuadrado.ancho
        cuadradoView.layoutParams.height = cuadrado.alto
        //Cambiamos el color
        cuadradoView.setBackgroundColor(cuadrado.color)
        //actualizar coordenadas


    }
}