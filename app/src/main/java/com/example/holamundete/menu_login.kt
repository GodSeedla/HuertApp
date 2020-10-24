package com.example.holamundete

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_menu_login.*


class menu_login : AppCompatActivity(), View.OnClickListener {
    private var omitir: Button? = null
    private var iniciarSesion: Button? = null
    private var registrarse: Button? = null
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_login)

        // Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integracion de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        omitir = findViewById(R.id.button_omitirInicioSesion)
        omitir!!.setOnClickListener(this)

        iniciarSesion = findViewById(R.id.button_inicioSesion)
        iniciarSesion!!.setOnClickListener(this)

        registrarse = findViewById(R.id.button_registrarse)
        registrarse!!.setOnClickListener(this)

    }

    fun Clean() {
        correoText.text = null
        PasswordText.text = null
    }


    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.button_omitirInicioSesion -> {
                startActivity(Intent(this@menu_login, menu_principal::class.java))
                Clean()
            }
            R.id.button_inicioSesion -> {
                //var admin = AdminSQLiteOpenHelper(this, "administracion", null, 1);
                //var BaseDeDatos: SQLiteDatabase = admin.writableDatabase;

                var email = correoText.text.toString()
                var password = PasswordText.text.toString()
                val length: Int

                if ((email.isNotEmpty() && password.isNotEmpty())) {

                    db.collection("usuario").document(email).get().addOnSuccessListener {
                        if (password == it.get("contraseña")) {
                            startActivity(Intent(this@menu_login, menu_principal::class.java))
                            Toast.makeText(this, "Inicio concedido", Toast.LENGTH_SHORT).show()
                            Clean()


                        /*var fila: Cursor = BaseDeDatos.rawQuery(
                            "select nickname from Usuarios where contraseña=" + password, null)

                        if (fila.moveToNext()) {
                            Toast.makeText(this, "Inicio concedido", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@menu_login, menu_principal::class.java))
                            Clean()
                        } else {
                            Toast.makeText(this, "Nombre de usuario o Contraseña incorrecta", Toast.LENGTH_LONG).show()
                            Clean()
                        }
                        fila.close()
                        BaseDeDatos.close()*/

                    }else{
                        Toast.makeText(this, "Nombre de usuario o Contraseña incorrecta", Toast.LENGTH_LONG).show()
                    }
                }
            }else{
                    Toast.makeText(this, "Ingrese una cuenta de usuario", Toast.LENGTH_LONG).show()
                }
            }
            R.id.button_registrarse -> {
                startActivity(Intent(this@menu_login, registro_usuario::class.java))
                Clean()
            }
        }
    }
}
