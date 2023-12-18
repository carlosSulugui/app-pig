package com.plusdesarrollo.mpxtoolkit.applist.utils

class Helper {
    fun isPalindromo(palabra: String): Boolean {
        var palabraInverida = ""
        for (i in palabra.length - 1 downTo 0) {
            palabraInverida += palabra[i]
        }
        return palabraInverida == palabra
    }

    fun notnegative(number: Int): Boolean {
        return number >= 0
    }


    //hacer un test de operaciones basicas

    fun operacionesBasicas(number1: Int, number2: Int, operacion: String): Boolean {
        var result = 0
        when (operacion) {
            "+" -> {
                if(number1== 0 && number2 == 0 )return false
                result = number1 + number2

            }

            "-" -> {
                if(number1== 0 && number2 == 0 )return false
                if(number1 <= 0 && number2 <= 0) return false
                result = number1 - number2

            }

            "*" -> {
                if(number1== 0 && number2 == 0 )return false
                result = number1 * number2
            }
            "/" -> {
                if(number1 <= 0 && number2 <= 0)
                if(number1 == 0 && number2 == 0) return false

                if(number1 >= 0 && number2 <= 0) return false
                if(number1 <=0  && number2 == 0 ) return false
                result = number1 / number2
            }
        }
        return result >= 0
    }

}