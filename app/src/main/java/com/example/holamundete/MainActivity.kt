package com.example.holamundete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun variablesYconstantes(){

        val largo = 5
        val ancho = 4
        val area = ancho*largo
        println(area)
    }

    private fun whensentence(){

        val country = "japon"

        when (country){
            "japon" -> {
                println("Nihongo desu")
            } "Chile" -> {
                println("Viva chile conchaetumare")
          }
        }
    }

}
