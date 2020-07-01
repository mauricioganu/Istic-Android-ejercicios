package com.example.appjuego

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_menu_de_juegos.*
import java.io.IOException
import java.io.OutputStreamWriter
import java.time.LocalDate

class menuDeJuegos : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_de_juegos)
        val btn_juego_Contador : Button =findViewById<Button>(R.id.btn_Juego_Contador)
        val btn_Juego_Numero :Button =findViewById<Button>(R.id.btn_Juego_Numero)
        btn_Juego_Contador.setOnClickListener {
            val intent: Intent = Intent(this, contador ::class.java)
            startActivity(intent)
            finish()
            try {
                val fecha = LocalDate.now()
                val usuario=intent.getStringExtra("mail");
                val Usuario_Logueado_2 = usuario
                val archivo = OutputStreamWriter(openFileOutput("score_numero.txt", Activity.MODE_APPEND))
                archivo.write("Usuario: "  + Usuario_Logueado_2 + "  " + "fecha: " + fecha + "\n")
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {

            }

        }
        btn_Juego_Numero.setOnClickListener {
            val intent: Intent = Intent(this, numeroSecreto ::class.java)
            startActivity(intent)
            finish()
            try {
                val fecha = LocalDate.now()
                val usuario=intent.getStringExtra("mail");
                val Usuario_Logueado_2 = usuario
                val archivo = OutputStreamWriter(openFileOutput("score_numero.txt", Activity.MODE_APPEND))
                archivo.write("Usuario: "  + Usuario_Logueado_2 + "  " + "fecha: " + fecha +  "\n")
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {

            }

        }










        }
    }



