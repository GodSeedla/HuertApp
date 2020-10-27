package com.example.holamundete

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_perfil_usuario.*

class perfilUsuario : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    var llamarUsuario = ""
    var llamarCultivos:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_usuario)

        VerificadorUsuario()
    }

    fun VerificadorUsuario(){
        llamarUsuario = menu_login.correo
        println("++++++++++++++++++++++++++++++++++++++++++++")
        println(llamarUsuario)
        db.collection("usuario").document(llamarUsuario).get().addOnSuccessListener {
            txt_nombrePerfilUsuario.text = it.get("nickname") as String?
            edit_numCultivos.text = it.get("numCultivos") as String?
        }

        if(menu_login.correo == "estoy vacio"){
            Toast.makeText(this, "Debes estar logeado para ver tu perdil", Toast.LENGTH_SHORT).show()
        }

    }

}
