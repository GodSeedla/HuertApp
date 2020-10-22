package com.example.holamundete

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class perfilUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_usuario)
    }

    var admin = AdminSQLiteOpenHelper(this,"administracion", null, 1);
    var BaseDeDatos: SQLiteDatabase = admin.writableDatabase;

    fun VerificadorUsuario(){

    }




}
