package com.example.holamundete

import android.app.Application

class fun_guardar : Application(){

    companion object{
        //declaramos las variables con las posiciones
        lateinit var pos11:guardar
        lateinit var pos12:guardar
        lateinit var pos21:guardar
        lateinit var pos22:guardar
        lateinit var posActual:String
    }

    override fun onCreate() {
        super.onCreate()
        pos11 = guardar(applicationContext)
        pos12 = guardar(applicationContext)
        pos21 = guardar(applicationContext)
        pos22 = guardar(applicationContext)
    }
}
