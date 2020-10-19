package com.example.holamundete

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_huerta_digital.*


class agregarCulti : Fragment(R.layout.fragment_agregar_culti) {
    private val db = FirebaseFirestore.getInstance()
    var nombCien1:String = ""
    var desc1:String = ""
    var nomb:String = ""

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        busquedaButton.setOnClickListener{
            if (preguntartextView.text.toString().isNotEmpty()){

                var textito = preguntartextView.text.toString()
                nomb = textito
                if (textito.isNotEmpty()){
                    while (db.collection("cultivo").document(textito) != null){
                        db.collection("cultivo").document(textito).get().addOnSuccessListener {
                            nombreCultivoTextView.text = nomb

                            nombreCientificoTextView.text = it.get("Nombre_Cientifico") as String?
                            nombCien1 = it.get("Nombre_Cientifico") as String

                            descripcionTextView.text = it.get("Descripcion") as String?
                            desc1 = it.get("Descripcion") as String

                            //riegoCultivoTextView.text = it.get("Riego") as String?
                            //climaCultTextView.text = it.get("Clima") as String?
                            //tiemCosechaTextView.text = it.get("Tiempo_cosecha") as String?
                            resultadoBusquedaTextView.text = "Exito"
                        }
                        break
                    }
                    db.collection("cultivo").document(textito).get().addOnFailureListener {
                        resultadoBusquedaTextView.text = "No se ha encontrado nada" as String?
                    }
                }
            }
        }

        agregarButton.setOnClickListener{
            //ifS para guardar los datos
            if(fun_guardar.posActual == "11" && nomb.isNotEmpty()){
                fun_guardar.pos11.guardarAlgo(nomb,"nomb"+ fun_guardar.posActual)
                fun_guardar.pos11.guardarAlgo(nombCien1, "nombCien"+ fun_guardar.posActual)
                fun_guardar.pos11.guardarAlgo(desc1, "desc"+ fun_guardar.posActual)
            }
            if(fun_guardar.posActual == "12" && nomb.isNotEmpty()){
                fun_guardar.pos12.guardarAlgo(nomb,"nomb"+ fun_guardar.posActual)
                fun_guardar.pos12.guardarAlgo(nombCien1, "nombCien"+ fun_guardar.posActual)
                fun_guardar.pos12.guardarAlgo(desc1, "desc"+ fun_guardar.posActual)
            }
            if(fun_guardar.posActual == "21" && nomb.isNotEmpty()){
                fun_guardar.pos21.guardarAlgo(nomb,"nomb"+ fun_guardar.posActual)
                fun_guardar.pos21.guardarAlgo(nombCien1, "nombCien"+ fun_guardar.posActual)
                fun_guardar.pos21.guardarAlgo(desc1, "desc"+ fun_guardar.posActual)
            }
            if(fun_guardar.posActual == "22" && nomb.isNotEmpty()){
                fun_guardar.pos22.guardarAlgo(nomb,"nomb"+ fun_guardar.posActual)
                fun_guardar.pos22.guardarAlgo(nombCien1, "nombCien"+ fun_guardar.posActual)
                fun_guardar.pos22.guardarAlgo(desc1, "desc"+ fun_guardar.posActual)
            }
        }

    }
}
