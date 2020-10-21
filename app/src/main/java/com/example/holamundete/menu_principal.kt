package com.example.holamundete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.view.View
import android.widget.Button
import com.example.holamundete.fun_guardar.Companion.pos11
import com.example.holamundete.fun_guardar.Companion.pos12
import com.example.holamundete.fun_guardar.Companion.pos21
import com.example.holamundete.fun_guardar.Companion.pos22
import kotlinx.android.synthetic.main.activity_menu_login.*
import kotlinx.android.synthetic.main.activity_menu_principal.*


class menu_principal : AppCompatActivity(), View.OnClickListener {
    private var info: Button? = null
    private var lupa: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        info = findViewById(R.id.infoButton)
        info!!.setOnClickListener(this)
        lupa = findViewById(R.id.lupaSearchButton)
        lupa!!.setOnClickListener(this)



    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.infoButton -> {
                startActivity(Intent(this@menu_principal, huerta_digital0::class.java))
            }
            R.id.lupaSearchButton -> {
                startActivity(Intent(this@menu_principal, busqueda::class.java))
            }
        }

    }
}
