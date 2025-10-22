package com.example.mayoredad

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mayoredad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numero : EditText = findViewById<EditText>(R.id.textoRellenar)
        val boton : Button = findViewById<Button>(R.id.botonPrincipal)
        val texto : TextView = findViewById<TextView>(R.id.textoSalida)

        val menos : Button = findViewById<Button>(R.id.botonmenor)
        val mas : Button = findViewById<Button>(R.id.buttonmayor)

        boton.setOnClickListener {
            //recoger el valor del texto y pasarelo a valor entero y metter un q dependiondo de la edad de respuessta
            val numeroResultado = numero.text.toString().toIntOrNull() //coges el text q es la propiedad del xml de la variable, lo pasas a string y luego a int
            /* //metodo con else if
            if (numeroResultado == null){
                texto.text = "Introduzca un valor"
            }else if (numeroResultado < 18){
                texto.text = "Eres menor de edad"
            }else if(numeroResultado>18){
                texto.text = "Eres mayor de edad"
            }else{
                texto.text = "Tienes justo 18 años"
            }*/

            texto.text = if (numeroResultado==null)"introduzca un valor"
            else if(numeroResultado<18)"eres menor de edad"
            else if (numeroResultado>18)"eres mayor de edad"
            else "justo tienes 18 años"
        }

        menos.setOnClickListener {
            val valorActual = numero.text.toString().toIntOrNull()
            if (valorActual == null) {
                texto.text = "introduzca un valor"
            } else if (valorActual > 0) {
                numero.setText((valorActual - 1).toString())
                texto.text = "Introduzca un valor"
            }

            actualizar(valorActual, texto,-1 )

            /*texto.text = if (valorActual==null)"introduzca un valor"
            else if(valorActual-1<18)"eres menor de edad"
            else if (valorActual-1>18)"eres mayor de edad"
            else "justo tienes 18 años"*/

        }


        mas.setOnClickListener {
            val valorActual = numero.text.toString().toIntOrNull()
            if (valorActual == null) {
                texto.text = "introduzca un valor"
            }else{
                numero.setText((valorActual + 1).toString())
            }

            actualizar(valorActual, texto,1 )

            /*texto.text = if (valorActual==null)"introduzca un valor"
            else if(valorActual+1<18)"eres menor de edad"
            else if (valorActual+1>18)"eres mayor de edad"
            else "justo tienes 18 años"*/

        }
    }

    private fun actualizar(edad : Int?, textoResultado : TextView, factor: Int){// int?, es q puede ser entero o nulo
        val mensaje = when{
            edad == null -> "Introduzca un valor"
            (edad + factor) < 18 -> "Eres menor de edad"
            (edad + factor) > 18 -> "Eres mayor de edad"
            else -> "Tienes justo 18 años"
        }
        textoResultado.text = mensaje
    }

}