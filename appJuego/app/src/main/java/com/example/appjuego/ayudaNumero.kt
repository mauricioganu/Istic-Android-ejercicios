package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_menu_de_juegos.*

class ayudaNumero : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda_numero)
        val btnVolver2 : Button =findViewById<Button>(R.id.btnVolver2)
        btnVolver2.setOnClickListener {
            val intent: Intent = Intent(this, contador ::class.java)
            startActivity(intent)
            finish()

        }
    }
}
