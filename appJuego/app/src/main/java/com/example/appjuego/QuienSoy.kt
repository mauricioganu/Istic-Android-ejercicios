package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_quien_soy.*

class QuienSoy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quien_soy)
        val btnSiguiente : Button =findViewById<Button>(R.id.btnSiguiente)
        btnSiguiente.setOnClickListener {
            val intent_siguiente: Intent = Intent(this,menuDeJuegos::class.java)
            startActivity(intent_siguiente)
            finish()
        }
        boton.setOnClickListener {
            val intent_siguiente: Intent = Intent(this,listadoRegistro::class.java)
            startActivity(intent_siguiente)
            finish()
        }
    }
}
