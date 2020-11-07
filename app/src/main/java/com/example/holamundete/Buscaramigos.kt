package com.example.holamundete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_buscar_amigos.*
import kotlinx.android.synthetic.main.activity_lista_pilar.*

class Buscaramigos : AppCompatActivity(), View.OnClickListener {
    /*private var agregar: Button? = null
    private var irperfil: Button? = null
    private var nombreAmigo: String? = null*/
    private val db = FirebaseFirestore.getInstance()
    var listaprueba = arrayListOf<String>()
    private var propietario = menu_login.correo
    private var contadoraux:Long = 0
    private var largoArray:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_amigos)

        btn_agregar.setOnClickListener() {

            // println(db.collection("usuario").document("ro@banu.com").("Amigos"))
            var amigotext = BuscaramigoTextView.text.toString()

            if (amigotext.isNotEmpty()) {
                //no tira el array de la firestore hacia listaprueba.

                db.collection("usuario").document(propietario).get().addOnSuccessListener {
                    listaprueba = it.get("Amigos") as ArrayList<String>
                    println("listaprueba en if" + listaprueba)
                }


                val docRef = db.collection("usuario").document(propietario)

                docRef.get().addOnSuccessListener { document ->
                    if (document.exists()) {

                        listaprueba.add(amigotext)

                        docRef.update(mapOf("Amigos" to listaprueba))

                        array = listaprueba
                        println("listaprueba en docref" + listaprueba)

                        println("++++++++++++++++++++++++++++++++++++++++++++++++++")
                        println(listaprueba)
                        println(array)


                    }

                }.addOnFailureListener { exception ->
                     Toast.makeText(
                           this,
                           "Se ha producido un error, intentelo de nuevo",
                           Toast.LENGTH_LONG
                        ).show()
                    }

                }

            }
            btn_perfil.setOnClickListener() {
                //Envía al perfil del usuario buscado
            }

            btn_listamigos.setOnClickListener() {
                startActivity(Intent(this@Buscaramigos, ListaPilar::class.java))

                db.collection("usuario").document(propietario).get().addOnSuccessListener {
                    listaprueba = it.get("Amigos") as ArrayList<String>
                    println("listaprueba en if" + listaprueba)

                    array = listaprueba

                }

            }




    }
    override fun onClick(p0: View?) { // no sirve pa na esta wea.


    }

    companion object{
        var array = arrayListOf<String>()
    }

}


/*BuscaramigoTextView.text = null
                              Toast.makeText(
                            this,
                            "Se ha agregado amigo exitosamente!",
                            Toast.LENGTH_LONG
                        ).show()
                        println("++++++++++++++++++++++++++++++++++++++++++++++++++")
                        //println(listaprueba[contadoraux])

                        println(largoArray)
                        println("contador:" + contadoraux)*/
