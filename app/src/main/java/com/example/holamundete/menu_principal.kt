package com.example.holamundete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_menu_login.*
import kotlinx.android.synthetic.main.activity_menu_principal.*


class menu_principal : AppCompatActivity(), View.OnClickListener {
    private var info: Button? = null
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        info = findViewById(R.id.infoButton)
        info!!.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        button2.setOnClickListener{
            startActivity(Intent(this@menu_principal, huerta_digital::class.java) )
        }
    }

}
