package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_ok_registro.*

class okRegistro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_registro)
        val btnOk : Button =findViewById<Button>(R.id.btnOk)
        btnOk.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity ::class.java)
            startActivity(intent)
            finish()
        }
    }
}
