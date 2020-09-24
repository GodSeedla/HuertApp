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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        info = findViewById(R.id.infoButton)
        info!!.setOnClickListener(this)

        //test
        /*button5.setOnClickListener{
            pos11.guardarNombre("Acelga", "pos11")
            pos12.guardarNombre("Aji", "pos12")
            pos21.guardarNombre("Ajo", "pos21")
            pos22.guardarNombre("Albahaca", "pos22")
        }
        buttonPoto.setOnClickListener{
            textView1.setText(pos11.getNomb("pos11"))
            textView2.setText(pos12.getNomb("pos12"))
            textView3.setText(pos21.getNomb("pos21"))
            textView4.setText(pos22.getNomb("pos22"))
        }*/
    }

    override fun onClick(p0: View?) {
        infoButton.setOnClickListener{
            startActivity(Intent(this@menu_principal, huerta_digital0::class.java) )
        }

        //con el click en el boton de "huerta digital". si la posicion (1,1) de la huerta tiene un cultivo
        //nos vamos a la actividad "huerta_digital2" de lo contrario vamos a "huerta:digital"
        /*if (pos11.getNomb("pos11") != " ") {
            infoButton.setOnClickListener{
                startActivity(Intent(this@menu_principal, huerta_digital2::class.java) )
            }
        }else {
            infoButton.setOnClickListener{
                startActivity(Intent(this@menu_principal, huerta_digital::class.java) )
            }
        }*/
    }
}
