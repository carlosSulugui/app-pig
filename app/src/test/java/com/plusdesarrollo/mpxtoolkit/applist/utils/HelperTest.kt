package com.plusdesarrollo.mpxtoolkit.applist.utils

import org.junit.Assert.*

class HelperTest {


    @org.junit.Testq
    fun `no admite ingresa numero 0`() {
        val helper = Helper()
        val result = helper.operacionesBasicas(0   , 0, "+")
        assertEquals(false, result)
    }

    @org.junit.Test
    fun `no permite realizar la siguente operacion dividir entre 0`(){
        val helper = Helper()
        val result = helper.operacionesBasicas(10   , 0, "/")
        assertEquals(false, result)
    }

    @org.junit.Test
    fun `realizando la operaciones con exito` (){
        val helper = Helper()
        val result = helper.operacionesBasicas( -1   , 0, "*")
        assertEquals(true , result)
    }


    @org.junit.Test
    fun `se admiten numeros negativos` (){
        val helper = Helper()
        val result = helper.operacionesBasicas(-1   , 0, "/")
        assertEquals(false, result)
    }

    @org.junit.Test
    fun `no se pueder dividir 0 entre 0 por que un numero indefinido`(){
        val helper = Helper()
        val result = helper.operacionesBasicas(-1   , -1, "/")
        assertEquals(true , result)
    }
}