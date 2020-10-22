package com.example.holamundete

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro_usuario.*

class registro_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)

        buttonRegistrarme.setOnClickListener(){
            Registrar_usuario()
        }
    }

    fun Registrar_usuario(){
        var admin = AdminSQLiteOpenHelper(this,"administracion", null, 1);
        var BaseDeDatos: SQLiteDatabase = admin.writableDatabase;

        var nombreUsuario = txt_nickname.text.toString()
        var emailUsuario = txt_emailUsuario.text.toString()
        var contraseñaUsuario = txt_contraseñaUsuario.text.toString()
        //var aleatorio:Int? = null



        var fila:Cursor = BaseDeDatos.rawQuery("select nickname, correo from Usuarios where contraseña=" + contraseñaUsuario,
                null)
            if (fila.moveToNext()){
                Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_LONG).show()
                txt_nickname.setText("")
                txt_emailUsuario.setText("")
                txt_contraseñaUsuario.setText("")
            }else {
                if (nombreUsuario.isNotEmpty() && emailUsuario.isNotEmpty() && contraseñaUsuario.isNotEmpty()) {

                    var registro = ContentValues();

                    //aleatorio++
                    registro.put("contraseña", contraseñaUsuario)
                    registro.put("nickname", nombreUsuario)
                    registro.put("correo", emailUsuario)
                    //registro.put("rutUsuario", aleatorio)

                    BaseDeDatos.insert("Usuarios", null, registro)
                    BaseDeDatos.close()
                    txt_nickname.setText("")
                    txt_emailUsuario.setText("")
                    txt_contraseñaUsuario.setText("")

                    Toast.makeText(this, "Registro de usuario exitoso", Toast.LENGTH_LONG).show()

                    startActivity(Intent(this@registro_usuario, menu_login::class.java))
                    }else{
                    Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show()
                }
                fila.close()
                BaseDeDatos.close()
            }
    }
}
