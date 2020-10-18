package com.example.holamundete

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.holamundete.fun_guardar.Companion.pos11
import com.example.holamundete.fun_guardar.Companion.pos12
import com.example.holamundete.fun_guardar.Companion.pos21
import com.example.holamundete.fun_guardar.Companion.pos22
import com.example.holamundete.fun_guardar.Companion.posActual
import kotlinx.android.synthetic.main.activity_huerta_digital0.*

class huerta_digital0 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_huerta_digital0)
        posActual = " "
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, bienvenida_huerta())
            commit()
        }

        //if que cambian el color de la huerta si hay algo dentro de ella a verde
        if (pos11.getAlgo("nomb11") != " "){
            button_pos11.setBackgroundColor(Color.GREEN)
        }else{
            button_pos11.setBackgroundColor(Color.GRAY)
        }

        if (pos12.getAlgo("nomb12") != " "){
            button_pos12.setBackgroundColor(Color.GREEN)
        }else{
            button_pos12.setBackgroundColor(Color.GRAY)
        }

        if (pos21.getAlgo("nomb21") != " "){
            button_pos21.setBackgroundColor(Color.GREEN)
        }else{
            button_pos21.setBackgroundColor(Color.GRAY)
        }

        if (pos22.getAlgo("nomb22") != " "){
            button_22.setBackgroundColor(Color.GREEN)
        }else{
            button_22.setBackgroundColor(Color.GRAY)
        }

        //las condiciones al apretar una huerta, si esta tiene un huerto nos lleva a la descripcion de este,
        //de lo contrario nos lleva a agregar uno
        button_pos11.setOnClickListener{
            posActual = "11"
            if (pos11.getAlgo("nomb11") != " "){
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, infCultivo())
                    commit()
                }
            }else{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, agregarCulti())
                    commit()
                }
            }
        }

        button_pos12.setOnClickListener{
            posActual = "12"
            if (pos12.getAlgo("nomb12") != " "){
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, infCultivo())
                    commit()
                }
            }else{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, agregarCulti())
                    commit()
                }
            }
        }

        button_pos21.setOnClickListener{
            posActual = "21"
            if (pos21.getAlgo("nomb21") != " "){
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, infCultivo())
                    commit()
                }
            }else{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, agregarCulti())
                    commit()
                }
            }
        }

        button_22.setOnClickListener{
            posActual = "22"
            if (pos22.getAlgo("22") != " "){
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, infCultivo())
                    commit()
                }
            }else{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, agregarCulti())
                    commit()
                }
            }
        }
    }
}
