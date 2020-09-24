package com.example.holamundete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.holamundete.fun_guardar.Companion.pos11
import com.example.holamundete.fun_guardar.Companion.pos12
import com.example.holamundete.fun_guardar.Companion.pos21
import com.example.holamundete.fun_guardar.Companion.pos22
import com.example.holamundete.fun_guardar.Companion.posActual
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_huerta_digital.*

class huerta_digital : AppCompatActivity(), View.OnClickListener {
    private var busq: Button? = null
    private val db = FirebaseFirestore.getInstance()
    var nombCien1:String = "hola"
    var desc1:String = "hola"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_huerta_digital)

        busq = findViewById(R.id.busquedaButton)
        busq!!.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        busquedaButton.setOnClickListener{

            if (preguntartextView.text.toString().isNotEmpty()){
                busquedaButton.setOnClickListener{
                    var textito = preguntartextView.text.toString()
                    val nomb = textito
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
                        db.collection("cultivo").document(textito).get().addOnFailureListener{
                            resultadoBusquedaTextView.text = "No se ha encontrado nada" as String?
                        }
                        agregar.setOnClickListener{
                            //ifS para guardar los datos
                            if(posActual == "11"){
                                pos11.guardarAlgo(nomb,"nomb"+ posActual)
                                pos11.guardarAlgo(nombCien1, "nombCien"+posActual)
                                pos11.guardarAlgo(desc1, "desc"+posActual)
                                startActivity(Intent(this@huerta_digital, huerta_digital2::class.java) )
                            }
                            if(posActual == "12"){
                                pos12.guardarAlgo(nomb,"nomb"+ posActual)
                                pos12.guardarAlgo(nombCien1, "nombCien"+posActual)
                                pos12.guardarAlgo(desc1, "desc"+posActual)
                                startActivity(Intent(this@huerta_digital, huerta_digital2::class.java) )
                            }
                            if(posActual == "21"){
                                pos21.guardarAlgo(nomb,"nomb"+ posActual)
                                pos21.guardarAlgo(nombCien1, "nombCien"+posActual)
                                pos21.guardarAlgo(desc1, "desc"+posActual)
                                startActivity(Intent(this@huerta_digital, huerta_digital2::class.java) )
                            }
                            if(posActual == "22"){
                                pos22.guardarAlgo(nomb,"nomb"+ posActual)
                                pos22.guardarAlgo(nombCien1, "nombCien"+posActual)
                                pos22.guardarAlgo(desc1, "desc"+posActual)
                                startActivity(Intent(this@huerta_digital, huerta_digital2::class.java) )
                            }
                        }
                    }
                }
            }
        }
    }
    }




