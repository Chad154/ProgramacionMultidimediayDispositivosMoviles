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

        val numero: EditText = findViewById(R.id.editText1)
        val boton: Button = findViewById(R.id.button1)
        val resultado: TextView = findViewById(R.id.textView1)

        boton.setOnClickListener {
            //Recoger el valor del campo texto, pasarlo a entero o null, meter in if dependiendo del valor da un resultado distinguiendo el nulo
            val edadString = numero.text.toString().toIntOrNull()
            /*
            if (edadString == null)
                resultado.text = "Introduzca un valor"
            else if (edadString < 18)
                resultado.text = "Eres menor de edad"
            else if (edadString > 18)
                resultado.text = "Eres mayor de edad"
            else resultado.text = "Tienes justo 18 años" */
            resultado.text = if (edadString == null) "Introduzca un valor"
            else if (edadString < 18) "Eres menor de edad"
            else if (edadString > 18) "Eres mayor de edad"
            else "Tienes justo 18 años"
        }

    }
}