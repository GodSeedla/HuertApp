package com.example.holamundete

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.holamundete.fun_guardar.Companion.pos11
import com.example.holamundete.fun_guardar.Companion.pos12
import com.example.holamundete.fun_guardar.Companion.pos21
import com.example.holamundete.fun_guardar.Companion.pos22
import com.example.holamundete.fun_guardar.Companion.posActual
import kotlinx.android.synthetic.main.activity_huerta_digital0.*
import kotlinx.android.synthetic.main.activity_huerta_digital2.*
import kotlinx.android.synthetic.main.activity_huerta_digital2.button
import kotlinx.android.synthetic.main.activity_huerta_digital2.button6
import kotlinx.android.synthetic.main.activity_huerta_digital2.button7
import kotlinx.android.synthetic.main.activity_huerta_digital2.button9

class huerta_digital2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_huerta_digital2)

        //if que cambian el color de la huerta si hay algo dentro de ella a verde
        if (pos11.getAlgo("nomb11") != " "){
            button.setBackgroundColor(Color.GREEN)
        }else{
            button.setBackgroundColor(Color.GRAY)
        }
        //+++++++++++++++++++++++++++++++++dejar "nomb1" como "nomb12"
        if (pos12.getAlgo("nomb1") != " "){
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

        //dependiendo de la posicion se muestra por pantalla las descripciones del cultivo
        if (posActual == "11"){
            nombre_cultivo.setText(pos11.getAlgo("nomb11"))
            nombre_cientifico.setText(pos11.getAlgo("nombCien11"))
            descripcion.setText(pos11.getAlgo("desc11"))
        }
        //++++++++++++++++++++++++++++++++dejar "pos11" como "pos12"
        if (posActual == "12"){
            nombre_cultivo.setText(pos11.getAlgo("nomb12"))
            nombre_cientifico.setText(pos12.getAlgo("nombCien12"))
            descripcion.setText(pos12.getAlgo("desc12"))
        }

        if (posActual == "21"){
            nombre_cultivo.setText(pos21.getAlgo("nomb21"))
            nombre_cientifico.setText(pos21.getAlgo("nombCien21"))
            descripcion.setText(pos21.getAlgo("desc21"))
        }

        if (posActual == "22"){
            nombre_cultivo.setText(pos22.getAlgo("nomb"+posActual))
            nombre_cientifico.setText(pos22.getAlgo("nombCien"+posActual))
            descripcion.setText(pos22.getAlgo("desc"+posActual))
        }

        //las condiciones al apretar una huerta, si esta tiene un huerto nos lleva a la descripcion de este,
        //de lo contrario nos lleva a agregar uno
        button.setOnClickListener{
            posActual = "11"
            if (pos11.getAlgo("nomb11") != " "){
                startActivity(Intent(this@huerta_digital2, huerta_digital2::class.java) )
            }else{
                startActivity(Intent(this@huerta_digital2, huerta_digital::class.java) )
            }
        }

        button6.setOnClickListener{
            posActual = "12"
            if (pos12.getAlgo("nomb12") != " "){
                startActivity(Intent(this@huerta_digital2, huerta_digital2::class.java) )
            }else{
                startActivity(Intent(this@huerta_digital2, huerta_digital::class.java) )
            }
        }

        button7.setOnClickListener{
            posActual = "21"
            if (pos21.getAlgo("nomb21") != " "){
                startActivity(Intent(this@huerta_digital2, huerta_digital2::class.java) )
            }else{
                startActivity(Intent(this@huerta_digital2, huerta_digital::class.java) )
            }
        }

        button9.setOnClickListener{
            posActual = "22"
            if (pos22.getAlgo("22") != " "){
                startActivity(Intent(this@huerta_digital2, huerta_digital2::class.java) )
            }else{
                startActivity(Intent(this@huerta_digital2, huerta_digital::class.java) )
            }
        }
    }
}
