package com.example.holamundete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_menu_login.*

class menu_login : AppCompatActivity(), View.OnClickListener {
    private var omitir: Button? = null
    private var iniciarSesion: Button? = null
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_login)

        // Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integracion de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        omitir = findViewById(R.id.button2)
        omitir!!.setOnClickListener(this)

        iniciarSesion = findViewById(R.id.button3)
        iniciarSesion!!.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        button2.setOnClickListener{
            startActivity(Intent(this@menu_login, menu_principal::class.java) )
            Clean()
        }

        button3.setOnClickListener{
            var user = userText.text.toString()
            var password = PasswordText.text.toString()
            val length: Int

            if ((user.isNotEmpty() && password.isNotEmpty())){

                db.collection("usuario").document(user).get().addOnSuccessListener {
                    if(password == it.get("contraseña")){
                        startActivity(Intent(this@menu_login, menu_principal::class.java) )
                        Clean()
                    }else{
                        errorView.text = "Nombre de usuario o Contraseña incorrecta" as String?
                    }

                }

            }
            if((userText.text.toString().isEmpty()&&(PasswordText.text.toString().isEmpty()))){
                errorView.text = "Ingrese una cuenta de usuario" as String?
            }
        }

    }

    fun Clean(){
        userText.text = null
        PasswordText.text = null
        errorView.text = null
    }

}

/*if((user == it.get("usuario")) &&
password == it.get("contraseña")){
    println("A")
    startActivity(Intent(this@menu_login, menu_principal::class.java) )

}else {
    println("stabrea")
}

 */
