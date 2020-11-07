package com.example.holamundete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_busqueda.*

class busqueda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busqueda)

        /*lupaCultivo.setOnSearchClickListener {
            println("Ola don pepitp")
            nombreCultivoBD.setText("Oliwi")
        }*/

        lupaCultivo.setOnCloseListener{
            println("Ola don pepitp")
            nombreCultivoBD.setText("Oliwi")
            true
        }


    }

    override fun onSearchRequested(): Boolean {

        println("Ola don pepitp")
        nombreCultivoBD.setText("Oliwi")
        return super.onSearchRequested()
    }


    companion object{
        lateinit var listamigos: String
    }

}
