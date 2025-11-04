package model

import android.R
import android.graphics.Color

class CuadradoBordes(color: Int, ancho: Int, alto: Int, var colorBorde: Int= Color.BLACK): Cuadrado(color,ancho,alto) {//cuando extiendes, no hace falta pner var
//añadimos un metodo nuevo del boton de cambiar borde
fun CambiarColorBorde(nuevoColorBorde: Int){
    colorBorde = nuevoColorBorde
}
    // Ejemplo de clase nested

    class ManejoColor{
        //Definimos objeto comun a toda la clase que son los colores
        companion object{
            val ROJO = Color.RED
            val AZUL = Color.BLUE
            val VERDE = Color.GREEN
            val BLANCO = Color.WHITE
            val NEGRO = Color.BLACK
            //Definimos el metodo de cambiar color
            fun ObtenerCincoColorRandomBorde() : Int{
                //Creamos una lista con los valores del companion object
                val colores = listOf(ROJO,AZUL,VERDE,BLANCO,NEGRO)
                return colores.random()

            }

        }


    }
}