package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quien_soy.*

class QuienSoy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quien_soy)
        btnSiguiente.setOnClickListener {
            val intent_siguiente: Intent = Intent(this,menuDeJuegos::class.java)
            startActivity(intent_siguiente)
            finish()
        }
    }
}
