package com.example.holamundete

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.holamundete.fun_guardar.Companion.pos11
import com.example.holamundete.fun_guardar.Companion.pos12
import com.example.holamundete.fun_guardar.Companion.pos21
import com.example.holamundete.fun_guardar.Companion.pos22
import com.example.holamundete.fun_guardar.Companion.posActual
import kotlinx.android.synthetic.main.fragment_inf_cultivo.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [infCultivo.newInstance] factory method to
 * create an instance of this fragment.
 */
class infCultivo : Fragment(R.layout.fragment_inf_cultivo) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //dependiendo de la posicion se muestra por pantalla las descripciones del cultivo
        if (posActual == "11"){
            nombre_cultivo.setText(pos11.getAlgo("nomb11"))
            nombre_cientifico.setText(pos11.getAlgo("nombCien11"))
            descripcion.setText(pos11.getAlgo("desc11"))
        }

        if (posActual == "12"){
            nombre_cultivo.setText(pos12.getAlgo("nomb12"))
            nombre_cientifico.setText(pos12.getAlgo("nombCien12"))
            descripcion.setText(pos12.getAlgo("desc12"))
        }

        if (fun_guardar.posActual == "21"){
            nombre_cultivo.setText(pos21.getAlgo("nomb21"))
            nombre_cientifico.setText(pos21.getAlgo("nombCien21"))
            descripcion.setText(pos21.getAlgo("desc21"))
        }

        if (posActual == "22"){
            nombre_cultivo.setText(pos22.getAlgo("nomb"+ posActual))
            nombre_cientifico.setText(pos22.getAlgo("nombCien"+ posActual))
            descripcion.setText(pos22.getAlgo("desc"+ posActual))
        }

        eliminar_huerta.setOnClickListener{
            if(posActual == "11"){
                pos11.borrar("nomb" + posActual)
                pos11.borrar("nombCien" + posActual)
                pos11.borrar("desc" + posActual)
            }else if (posActual == "12"){
                pos12.borrar("nomb" + posActual)
                pos12.borrar("nombCien" + posActual)
                pos12.borrar("desc" + posActual)
            }else if (posActual == "21"){
                pos21.borrar("nomb" + posActual)
                pos21.borrar("nombCien" + posActual)
                pos21.borrar("desc" + posActual)
            }else if (posActual == "22"){
                pos22.borrar("nomb" + posActual)
                pos22.borrar("nombCien" + posActual)
                pos22.borrar("desc" + posActual)
            }
        }
    }
}
