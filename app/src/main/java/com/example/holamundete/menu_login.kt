package com.example.holamundete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_menu_login.*

class menu_login : AppCompatActivity(), View.OnClickListener {
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_login)

        // Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integracion de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        button = findViewById(R.id.button2)
        button!!.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        button2.setOnClickListener{
            startActivity(Intent(this@menu_login, menu_principal::class.java) )
        }
    }


}
