package com.example.holamundete

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.holamundete.fun_guardar.Companion.pos11
import com.example.holamundete.fun_guardar.Companion.pos12
import com.example.holamundete.fun_guardar.Companion.pos21
import com.example.holamundete.fun_guardar.Companion.pos22
import com.example.holamundete.fun_guardar.Companion.posActual
import kotlinx.android.synthetic.main.activity_huerta_digital0.*
import kotlinx.android.synthetic.main.activity_menu_principal.*

class huerta_digital0 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_huerta_digital0)

        //if que cambian el color de la huerta si hay algo dentro de ella a verde
        if (pos11.getAlgo("nomb11") != " "){
            button.setBackgroundColor(Color.GREEN)
        }else{
            button.setBackgroundColor(Color.GRAY)
        }

        if (pos12.getAlgo("nomb12") != " "){
            button6.setBackgroundColor(Color.GREEN)
        }else{
            button6.setBackgroundColor(Color.GRAY)
        }

        if (pos21.getAlgo("nomb21") != " "){
            button7.setBackgroundColor(Color.GREEN)
        }else{
            button7.setBackgroundColor(Color.GRAY)
        }

        if (pos22.getAlgo("nomb22") != " "){
            button9.setBackgroundColor(Color.GREEN)
        }else{
            button9.setBackgroundColor(Color.GRAY)
        }

        //las condiciones al apretar una huerta, si esta tiene un huerto nos lleva a la descripcion de este,
        //de lo contrario nos lleva a agregar uno
        button.setOnClickListener{
            posActual = "11"
            if (pos11.getAlgo("nomb11") != " "){
                startActivity(Intent(this@huerta_digital0, huerta_digital2::class.java) )
            }else{
                startActivity(Intent(this@huerta_digital0, huerta_digital::class.java) )
            }
        }

        button6.setOnClickListener{
            posActual = "12"
            if (pos12.getAlgo("nomb12") != " "){
                startActivity(Intent(this@huerta_digital0, huerta_digital2::class.java) )
            }else{
                startActivity(Intent(this@huerta_digital0, huerta_digital::class.java) )
            }
        }

        button7.setOnClickListener{
            posActual = "21"
            if (pos21.getAlgo("nomb21") != " "){
                startActivity(Intent(this@huerta_digital0, huerta_digital2::class.java) )
            }else{
                startActivity(Intent(this@huerta_digital0, huerta_digital::class.java) )
            }
        }

        button9.setOnClickListener{
            posActual = "22"
            if (pos22.getAlgo("22") != " "){
                startActivity(Intent(this@huerta_digital0, huerta_digital2::class.java) )
            }else{
                startActivity(Intent(this@huerta_digital0, huerta_digital::class.java) )
            }
        }
    }
}
