package com.example.holamundete

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu_principal.*


class menu_principal : AppCompatActivity(), View.OnClickListener {
    private var info: Button? = null
    private var lupa: Button? = null
    private var amigo: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        info = findViewById(R.id.infoButton)
        info!!.setOnClickListener(this)
        lupa = findViewById(R.id.lupaSearchButton)
        lupa!!.setOnClickListener(this)
        amigo = findViewById(R.id.btn_amigo)
        amigo?.setOnClickListener(this)


        perfilButton.setOnClickListener(){
            irAPerfil()
        }
    }
    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.infoButton -> {
                startActivity(Intent(this@menu_principal, huerta_digital0::class.java))
            }
            R.id.lupaSearchButton -> {
                startActivity(Intent(this@menu_principal, buscador_digital::class.java))
            }
            R.id.btn_amigo -> {
                startActivity(Intent(this@menu_principal, Buscaramigos::class.java))
            }

        }

    }

    fun irAPerfil(){
        startActivity(Intent(this@menu_principal, perfilUsuario::class.java))
    }


}
