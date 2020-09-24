package com.example.holamundete

import android.content.Context

class guardar(val context:Context) {

    //nombre de la base de datos
    val culti = "Cultivos"

    //variable que contiene el contexto
    val almacenamiento = context.getSharedPreferences(culti, 0)

    //para el metodo de guardar datos ver al final de esta clase
    //funcion que guarda el nombre el la base de datos
    fun guardarAlgo(nombre: String, posNo: String){
        almacenamiento.edit().putString(posNo, nombre).apply()
    }

    //funcion que nos retorna el nombre
    fun getAlgo(posNo:String):String{
        return almacenamiento.getString(posNo, " ")!!
    }
}
//para guardar datos se debe especificar el nombre/tipo y lo que contiene
//ejemplo: pos11.guardarAlgo("Aji"[lo que contiene el dato], "nomb12"[el nombre del dato])
//tipos de datos. Cada tipo de datos va seguido de su posicion en la matriz de la huerta digital.
//nomb = nombre del cultivo
//nombCien = nombre cientifico
//desc = descripcion del cultivo
