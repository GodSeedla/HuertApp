package com.example.holamundete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_buscador_digital.*
import android.widget.BaseAdapter;

class ListaPilar : AppCompatActivity() {
    private var lista_mostrar = Buscaramigos.array
    private val db = FirebaseFirestore.getInstance()
    private val propietario = menu_login.correo
    val docRef = db.collection("usuario").document(propietario)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_amigos)





        println("++++++++++++++++++++++++++++++++++++++++++")
        println("propietario: " + propietario)
        println("lista:" + lista_mostrar)


    }



}


