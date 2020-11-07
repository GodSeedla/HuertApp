package com.example.holamundete

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Random
import kotlinx.android.synthetic.main.activity_registro_usuario.*

class registro_usuario : AppCompatActivity(), View.OnClickListener {
    private val db = FirebaseFirestore.getInstance()
    private var regi:Button? = null
    var nombreUsuario:String = ""
    var emailUsuario:String = ""
    var passwordUser:String = ""
    var cantidadCultivos:Long? = null
    var nAleatorio = Random()
    var arrayamigos = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)

        regi = findViewById(R.id.buttonRegistrarme)
        regi!!.setOnClickListener(this)

    }


    private fun Registrar_usuario(){

                 nombreUsuario = txt_nickname.text.toString()
                 emailUsuario = txt_emailUsuario.text.toString()
                 passwordUser = txt_contraseñaUsuario.text.toString()


                if (nombreUsuario.isNotEmpty() && emailUsuario.isNotEmpty() && passwordUser.isNotEmpty()){
                    //Las siguientes lineas de código tienen la funcion de entrar a la BD y verificar si el usuario ya existe o no

                    val docRef = db.collection("usuario").document(emailUsuario)
                    //creamos un valor para ahorrarnos espacio de código

                    docRef.get().addOnSuccessListener { document -> //Entramos a la Cloud Firestore y verificamos si existe el usuario
                        if (document.exists()){
                            Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_LONG).show()

                        }else{
                            var idAleatorio = nAleatorio.nextInt(999) + 1
                            //creamos una id aleatoria para más tarde buscar al usuario dentro de la app

                            docRef.set(
                                hashMapOf("id" to idAleatorio, "nickname" to nombreUsuario, /*"contraseña" to passwordUser,*/
                                    "numCultivos" to cantidadCultivos, "Amigos" to arrayamigos))

                            var admin = AdminSQLiteOpenHelper(this,"administracion", null, 1);
                            var BaseDeDatos:SQLiteDatabase = admin.writableDatabase;

                            var registro = ContentValues();
                            registro.put("contraseña", passwordUser)
                            registro.put("id", idAleatorio)
                            BaseDeDatos.insert("Usuarios", null, registro)
                            BaseDeDatos.close()

                            Toast.makeText(this, "Registro de usuario exitoso", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this@registro_usuario, menu_login::class.java))
                        }
                    }.addOnFailureListener { exception ->
                        Toast.makeText(this, "No se encontró la BD", Toast.LENGTH_LONG).show()
                    }

                        /*var admin = AdminSQLiteOpenHelper(this,"administracion", null, 1);
                        var BaseDeDatos: SQLiteDatabase = admin.writableDatabase;
                        var registro = ContentValues();

                        registro.put("contraseña", contraseñaUsuario)

                        BaseDeDatos.insert("Usuarios", null, registro)
                        BaseDeDatos.close()*/
                    //}
                }else{
                    Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show()
                }
}

    override fun onClick(p0: View?) {
            Registrar_usuario()
    }

    /*fun Registrar_usuario(){
        //var admin = AdminSQLiteOpenHelper(this,"administracion", null, 1);
        //var BaseDeDatos: SQLiteDatabase = admin.writableDatabase;

        if (db.collection("usuario").document(emailUsuario) != null){
            Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_LONG).show()
        }else{
            db.collection("usuario").document(emailUsuario)
        }

        /*var fila:Cursor = BaseDeDatos.rawQuery("select nickname, correo from Usuarios where contraseña=" + contraseñaUsuario,
                null)
            if (fila.moveToNext()){
                Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_LONG).show()
                txt_nickname.setText("")
                txt_emailUsuario.setText("")
                txt_contraseñaUsuario.setText("")
            }else {
                if (nombreUsuario.isNotEmpty() && emailUsuario.isNotEmpty() && contraseñaUsuario.isNotEmpty()) {

                    var registro = ContentValues();

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
            }*/
    }*/
}
