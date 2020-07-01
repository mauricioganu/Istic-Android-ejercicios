package com.example.appjuego

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_quien_soy.*
import java.io.IOException
import java.io.OutputStreamWriter
import java.time.LocalDate

class QuienSoy : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quien_soy)
        val btnSiguiente : Button =findViewById<Button>(R.id.btnSiguiente)
       /* btnSiguiente.setOnClickListener {
            val intent_siguiente: Intent = Intent(this,menuDeJuegos::class.java)
            startActivity(intent_siguiente)
            finish()
        } */
       /* boton.setOnClickListener {
            val intent_siguiente: Intent = Intent(this,listadoRegistro::class.java)
            startActivity(intent_siguiente)
            finish()
        } */
        val usuario=intent.getStringExtra("mail");
        val Usuario_Logueado_2 = usuario

        val fecha = LocalDate.now()
        /* val localDate:LocalDate = LocalDate.now()
         val dateTimeFormatter:DateTimeFormatter = DateTimeFormatter.ofPattern("dd,mm,yyyy")
         val fecha = localDate.format(dateTimeFormatter)*/

        btnSiguiente.setOnClickListener {


            try {
                val usuario=intent.getStringExtra("mail");
                val Usuario_Logueado_2 = usuario

                val fecha = LocalDate.now()
                val archivo = OutputStreamWriter(openFileOutput("score_contador.txt", Activity.MODE_APPEND))
                archivo.write("Usuario: "  + Usuario_Logueado_2 + "  " + "fecha: " + fecha + "\n")
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {

            }


            try {
                val usuario=intent.getStringExtra("mail");
                val Usuario_Logueado_2 = usuario

                val fecha = LocalDate.now()
                val archivo = OutputStreamWriter(openFileOutput("score_numero.txt", Activity.MODE_APPEND))
                archivo.write("Usuario: "  + Usuario_Logueado_2 + "  " + "fecha: " + fecha +  "\n")
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {

            }

            val intent_2:Intent = Intent (this, menuDeJuegos::class.java)

            startActivity(intent_2)

            finish()

        }
    }

    }

