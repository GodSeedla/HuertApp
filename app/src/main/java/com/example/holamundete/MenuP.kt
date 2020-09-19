package com.example.holamundete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_menu_p.*


class MenuP : AppCompatActivity(), View.OnClickListener {
    private var info: Button? = null
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_p)

        info = findViewById(R.id.infoButton)
        info!!.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        infoButton.setOnClickListener {
            db.collection("cultivo").document("ZAna01").get().addOnSuccessListener {
                cultivoTextView.text = it.get("Descripcion") as String?
            }
        }
    }

}
