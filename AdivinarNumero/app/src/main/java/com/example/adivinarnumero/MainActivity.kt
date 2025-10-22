package com.example.adivinarnumero

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    val numeroIntroducido : EditText = findViewById(R.id.editTextInput)
    val boton : Button = findViewById(R.id.buttonCheck)
    val mensajeSalida : TextView = findViewById(R.id.textViewResult)
    var numeroAleatorio = Random.nextInt(1,101)
    var contador = 0
    boton.setOnClickListener {
        //Recogemos el valor
        contador ++;
        val valorIntroducido = numeroIntroducido.text.toString().toIntOrNull()
        if (valorIntroducido == null) mensajeSalida.text="Introduzca un valor"
        else if (valorIntroducido > numeroAleatorio) mensajeSalida.text="El valor es menor a tu numero"
        else if (valorIntroducido < numeroAleatorio) mensajeSalida.text="El valor es mayor a tu numero"
        else mensajeSalida.text = "Muy bien has acertado el numero, el numero es " + numeroAleatorio.toString() + " y has usado " + contador + " intentos"


    }
        }
    }
