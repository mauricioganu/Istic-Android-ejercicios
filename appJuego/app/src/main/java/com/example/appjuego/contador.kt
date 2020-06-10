package com.example.appjuego

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ayuda_contador.*
import kotlinx.android.synthetic.main.activity_contador.*
import java.io.IOException
import java.io.OutputStreamWriter

class contador : AppCompatActivity() {
    var contador_contador=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)
        val btnContar :Button =findViewById<Button>(R.id.btnContar)
        val btnReset :Button =findViewById<Button>(R.id.btnReset)
        val btn_ayuda_c:Button =findViewById<Button>(R.id.btn_ayuda_c)
        val btnVolver :Button =findViewById<Button>(R.id.btnVolver)
        val objetoAContar :TextView =findViewById<TextView>(R.id.objetoAContar)
        val txtContando :TextView =findViewById<TextView>(R.id.txtContando)
        val btnGuardar : Button =findViewById<Button>(R.id.btnGuardar)

        btnContar.setOnClickListener{
            contador_contador ++

            txtContando.text=contador_contador.toString()

        }
        btnReset.setOnClickListener{
            contador_contador=0
            txtContando.text=contador_contador.toString()
        }
        btn_ayuda_c.setOnClickListener{
        val intent: Intent = Intent(this, ayudaContador ::class.java)
        startActivity(intent)

        finish()
    }
        btnVolver.setOnClickListener{
            val intent: Intent = Intent(this, menuDeJuegos ::class.java)
            startActivity(intent)

            finish()
        }

        btnGuardar.setOnClickListener {
            val intent: Intent = Intent(this, guardar_valor_contador ::class.java)
            startActivity(intent)

            finish()
            try {
                val archivo = OutputStreamWriter(openFileOutput("datos.txt", Activity.MODE_APPEND))
                archivo.write(objetoAContar.text.toString()  +"  " + txtContando.text.toString() + "\n")
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {

            }
            Toast.makeText(this, "Se ha guardado con éxito", Toast.LENGTH_SHORT).show()

        }



    }
}
