package com.example.holamundete

import android.app.Application

class fun_guardar : Application(){

    companion object{
        //declaramos las variables con las posiciones
        //lateinit var pos11: String
        lateinit var posActual:String
    }

    //crear shared preference
    override fun onCreate() {
        super.onCreate()
        //pos11 = guardar(applicationContext)
    }
}
