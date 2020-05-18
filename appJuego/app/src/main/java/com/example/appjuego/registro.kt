package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ok_registro.*
import kotlinx.android.synthetic.main.activity_registro.*

class registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        btn_registro.setOnClickListener {
            val intent: Intent =Intent(this,okRegistro ::class.java)
            startActivity(intent)

        }

    }
}
