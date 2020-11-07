package com.example.holamundete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_perfil_amigo.*
import kotlinx.android.synthetic.main.activity_perfil_usuario.*

class perfilAmigo : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    var correoAmigo =  ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_amigo)

        VerificadorAmigo()
    }
    fun VerificadorAmigo(){
        correoAmigo = Buscaramigos.correoUsuarioAmigo

        db.collection("usuario").document(correoAmigo).get().addOnSuccessListener {
            txt_nombrePerfilAmigo.text = it.get("nickname") as String?
            edit_numCultivosAmigo.text = (it.get("numCultivos") as Long?).toString()
            }.addOnFailureListener{
                Toast.makeText(this, "No se encotnró tal usuario", Toast.LENGTH_SHORT).show()
            }
    }
}
