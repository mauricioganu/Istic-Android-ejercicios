package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_menu_de_juegos.*

class menuDeJuegos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_de_juegos)
        val btn_juego_Contador : Button =findViewById<Button>(R.id.btn_Juego_Contador)
        val btn_Juego_Numero :Button =findViewById<Button>(R.id.btn_Juego_Numero)
        btn_Juego_Contador.setOnClickListener {
            val intent: Intent = Intent(this, contador ::class.java)
            startActivity(intent)
            finish()

        }
        btn_Juego_Numero.setOnClickListener {
            val intent: Intent = Intent(this, numeroSecreto ::class.java)
            startActivity(intent)
            finish()

        }
    }
}
