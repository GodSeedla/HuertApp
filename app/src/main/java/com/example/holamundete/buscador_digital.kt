package com.example.holamundete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.holamundete.fun_guardar.Companion.posActual
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_buscador_digital.*

class buscador_digital : AppCompatActivity(), View.OnClickListener {
    private var busq: Button? = null
    private var add: Button? = null
    private val db = FirebaseFirestore.getInstance()
    var nombCien1:String = ""
    var desc1:String = ""
    var nomb:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscador_digital)

        busq = findViewById(R.id.busquedaButton)
        add = findViewById(R.id.agregarButton)
        add!!.setOnClickListener(this)
        busq!!.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {

        when(p0!!.id){
            R.id.busquedaButton->{
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
        }
    }
}




