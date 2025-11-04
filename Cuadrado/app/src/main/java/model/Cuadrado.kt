package model

open class Cuadrado(var color: Int, var ancho: Int, var alto:Int) {
    //Coordenadas Iniciales

    var x : Int = 0
    var y : Int = 0

    //metodo para mover-cambial el cuadrado

    fun moverArriba(){
        y-=10
    }

    fun moverAbajo(){
        y+=10
    }

    fun moverDerecha(){
        x+=10
    }

    fun moverIzquierda(){
        x-=10
    }

    fun cambiarTamanio(nuevoAncho: Int, nuevoAlto: Int){
        ancho = nuevoAncho
        alto = nuevoAlto
    }

}