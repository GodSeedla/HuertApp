package com.example.holamundete

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.holamundete.fun_guardar.Companion.posActual
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_inf_cultivo.*

class infCultivo : Fragment(R.layout.fragment_inf_cultivo) {
    private val db = FirebaseFirestore.getInstance()
    var eliminarCultivo:String = ""

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //conexto del fragment
        val appContext = requireContext().applicationContext

        //variables de SQLite para abrir la base de datos
        var admin = AdminSQLiteOpenHelper(appContext,"administracion", null, 1)
        var BaseDeDatos: SQLiteDatabase = admin.writableDatabase

        //variable de query
        var fila: Cursor = BaseDeDatos.rawQuery("select nombre, nomCien, descri from Cultivos where IDculti =" + posActual, null)

        //
        if (fila.moveToNext()){
            nombre_cultivo.setText(fila.getString(0))
            nombre_cientifico.setText((fila.getString(1)))
            descripcion.setText((fila.getString(2)))
        }

        eliminar_huerta.setOnClickListener{
            BaseDeDatos.delete("Cultivos", "IDculti=" + posActual, null)

            //Eliminamos el cultivo de la BD del usuario
            var docRef = db.collection("usuario")

            docRef.document(menu_login.correo).get().addOnSuccessListener {
                eliminarCultivo = it.get("numCultivos") as String
                if (eliminarCultivo == "1"){
                    docRef.document(menu_login.correo).update("numCultivos", "0")
                    //agregarCulti().cultivos = "0"
                }else if (eliminarCultivo == "2"){
                    docRef.document(menu_login.correo).update("numCultivos", "1")
                    //agregarCulti().cultivos = "1"
                }else if (eliminarCultivo == "3"){
                    docRef.document(menu_login.correo).update("numCultivos", "2")
                    //agregarCulti().cultivos = "2"
                }else if (eliminarCultivo == "4"){
                    docRef.document(menu_login.correo).update("numCultivos", "3")
                    //agregarCulti().cultivos = "3"
                }else{}
            }

        }
        /*fila.close()
        BaseDeDatos.close()*/
    }
}
