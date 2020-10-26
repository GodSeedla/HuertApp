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
import com.example.holamundete.fun_guardar.Companion.pos11
import com.example.holamundete.fun_guardar.Companion.pos12
import com.example.holamundete.fun_guardar.Companion.pos21
import com.example.holamundete.fun_guardar.Companion.pos22
import com.example.holamundete.fun_guardar.Companion.posActual
import kotlinx.android.synthetic.main.fragment_inf_cultivo.*

class infCultivo : Fragment(R.layout.fragment_inf_cultivo) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //conexto del fragment
        val appContext = context!!.applicationContext

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
        }
        /*fila.close()
        BaseDeDatos.close()*/
    }
}
