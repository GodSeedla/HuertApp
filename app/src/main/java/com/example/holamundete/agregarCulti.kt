package com.example.holamundete

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.holamundete.fun_guardar.Companion.posActual
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
    var posActualNum = posActual.toInt()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //conexto del fragment
        val appContext = context!!.applicationContext

        //variables de SQLite para abrir la base de datos
        var admin = AdminSQLiteOpenHelper(appContext,"administracion", null, 1)
        var BaseDeDatos: SQLiteDatabase = admin.writableDatabase

        //variable "registro" guarda los datos a almacenar en la base de datos
        var registro = ContentValues()

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

            //guardamos los datos en "registro" para luego almacenarlos en su respectiva tabla
            registro.put("IDculti", posActualNum)
            registro.put("nombre", nomb)
            registro.put("nomCien", nombCien1)
            registro.put("descri", desc1)
            BaseDeDatos.insert("Cultivos", null, registro);

            Toast.makeText(appContext, "Datos guardados correctamente", Toast.LENGTH_SHORT).show()

            BaseDeDatos.close()
        }

    }
}
