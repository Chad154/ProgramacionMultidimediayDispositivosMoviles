package com.example.kebab.data

import com.example.kebab.R

data class Comida(val id: Int, val nombre: String, val imagen: Int, val descripcion: String) {
    object RepositorioComida {
        val listaComida = listOf(
            Comida(
                1, "kebab", R.drawable.kebab,
                "Kebab rico bonito y barato, hay mixto, ternera o pollo. Extra de salsa o carne mas precio amego"
            ),
            Comida(
                2, "Durum", R.drawable.falafel,
                "Durum rico bonito y barato, hay mixto, ternera o pollo. Extra de salsa o carne mas precio amego"
            ),
            Comida(
                3,
                "Falafel",
                R.drawable.falafel,
                "Falafel rico bonito y barato, hay mixto, ternera o pollo." +
                        " Extra de salsa o carne mas precio amego"
            )
        )

        //Funcion que devuelva la casa
        /*fun getComidaById(id:Int):Comida?{
            for(comida in listaComida){
                if(comida.id == id){
                    return comida
                }
            }
            return null
        }*/

        fun getComidaById(id:Int):Comida?{
            return listaComida.find { it.id == id }
        }
    }
}