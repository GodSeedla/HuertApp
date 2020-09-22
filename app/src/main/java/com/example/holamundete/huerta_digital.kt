package com.example.holamundete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_huerta_digital.*

class huerta_digital : AppCompatActivity(), View.OnClickListener {
    private var busq: Button? = null
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_huerta_digital)

        busq = findViewById(R.id.busquedaButton)
        busq!!.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        busquedaButton.setOnClickListener{

            if (preguntartextView.text.toString().isNotEmpty()){
              /*   if (preguntartextView.text.toString() != null){
                    db.collection("cultivo").document(preguntartextView.text.toString()).get().addOnSuccessListener {
                        nombreCultivoTextView.text = preguntartextView.text.toString()
                        nombreCientificoTextView.text = it.get("Nombre_Cientifico") as String?
                        descripcionTextView.text = it.get("Descripcion") as String?
                    }
                } else {
                    resultadoBusquedaTextView.text = "No se ha encontrado"
                }*/
                busquedaButton.setOnClickListener{

                    var textito = preguntartextView.text.toString()

                    if (textito.isNotEmpty()){
                        while (db.collection("cultivo").document(textito) != null){
                            db.collection("cultivo").document(textito).get().addOnSuccessListener {
                                nombreCultivoTextView.text = textito
                                nombreCientificoTextView.text = it.get("Nombre_Cientifico") as String?
                                descripcionTextView.text = it.get("Descripcion") as String?
                            }
                            break
                        }
                        resultadoBusquedaTextView.text = "No se ha encontrado nada" as String?
                    }


                }
            }
            }
        }
    }




