package com.example.factorial

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val numero: EditText = findViewById(R.id.editTextText)
        val textoResultadp: TextView = findViewById(R.id.textView)
        val boton: Button = findViewById(R.id.boton)
        boton.setOnClickListener {
            val numeroResultado = numero.text.toString().toIntOrNull()
            if (numeroResultado != null) {
                textoResultadp.text=factorial(numeroResultado).toString()
            } else {
                textoResultadp.text = "Introduce un numero valido"
            }

        }

    }

    private fun factorial(numero: Int): Int {
        var resultado = 1
        for (i in 1..numero) {
            resultado *= i
        }
        return resultado
    }

}