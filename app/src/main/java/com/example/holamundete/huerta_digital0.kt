package com.example.holamundete

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.holamundete.fun_guardar.Companion.pos11
import com.example.holamundete.fun_guardar.Companion.pos12
import com.example.holamundete.fun_guardar.Companion.pos21
import com.example.holamundete.fun_guardar.Companion.pos22
import com.example.holamundete.fun_guardar.Companion.posActual
import kotlinx.android.synthetic.main.activity_huerta_digital0.*

class huerta_digital0 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_huerta_digital0)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, bienvenida_huerta())
            commit()
        }

        //variables de SQLite para abrir la base de datos
        var admin = AdminSQLiteOpenHelper(this,"administracion", null, 1)
        var BaseDeDatos: SQLiteDatabase = admin.writableDatabase

        posActual = "11"

        //variables de query para ver si hay datos por cada posicion
        var fila: Cursor = BaseDeDatos.rawQuery("select nombre from Cultivos where IDculti =" + posActual, null)

        //if que cambian el color de la huerta si hay algo dentro de ella a verde
        if (fila.moveToFirst()){
            button_pos11.setBackgroundColor(Color.GREEN)
        }else{
            button_pos11.setBackgroundColor(Color.GRAY)
        }
        //fila.close()

        posActual = "12"

        fila = BaseDeDatos.rawQuery("select nombre from Cultivos where IDculti =" + posActual, null)

        if (fila.moveToFirst()){
            button_pos12.setBackgroundColor(Color.GREEN)
        }else{
            button_pos12.setBackgroundColor(Color.GRAY)
        }
        //fila.close()

        posActual = "21"

        fila = BaseDeDatos.rawQuery("select nombre from Cultivos where IDculti =" + posActual, null)

        if (fila.moveToFirst()){
            button_pos21.setBackgroundColor(Color.GREEN)
        }else{
            button_pos21.setBackgroundColor(Color.GRAY)
        }

        posActual = "22"

        fila = BaseDeDatos.rawQuery("select nombre from Cultivos where IDculti =" + posActual, null)

        if (fila.moveToFirst()){
            button_22.setBackgroundColor(Color.GREEN)
        }else{
            button_22.setBackgroundColor(Color.GRAY)
        }

        //las condiciones al apretar una huerta, si esta tiene un huerto nos lleva a la descripcion de este,
        //de lo contrario nos lleva a agregar uno
        button_pos11.setOnClickListener{
            posActual = "11"
            fila = BaseDeDatos.rawQuery("select nombre from Cultivos where IDculti =" + posActual, null)
            if (fila.moveToFirst()){
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, infCultivo())
                    commit()
                }
            }else{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, agregarCulti())
                    commit()
                }
            }
        }

        button_pos12.setOnClickListener{
            posActual = "12"
            fila = BaseDeDatos.rawQuery("select nombre from Cultivos where IDculti =" + posActual, null)
            if (fila.moveToFirst()){
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, infCultivo())
                    commit()
                }
            }else{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, agregarCulti())
                    commit()
                }
            }
        }

        button_pos21.setOnClickListener{
            posActual = "21"
            fila = BaseDeDatos.rawQuery("select nombre from Cultivos where IDculti =" + posActual, null)
            if (fila.moveToFirst()){
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, infCultivo())
                    commit()
                }
            }else{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, agregarCulti())
                    commit()
                }
            }
        }

        button_22.setOnClickListener{
            posActual = "22"
            fila = BaseDeDatos.rawQuery("select nombre from Cultivos where IDculti =" + posActual, null)
            if (fila.moveToFirst()){
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, infCultivo())
                    commit()
                }
            }else{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, agregarCulti())
                    commit()
                }
            }
        }
        /*fila.close()
        BaseDeDatos.close()*/
    }
}
