package com.example.appjuego

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contador.*
import kotlinx.android.synthetic.main.activity_guardar_valor_contador.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class guardar_valor_contador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardar_valor_contador)
        val btnVolver : Button =findViewById<Button>(R.id.btnVolver)
        val txtMultilinea : TextView =findViewById<TextView>(R.id.txtMultilinea)
        val btnReset : Button =findViewById<Button>(R.id.btnReset)
        btnVolver.setOnClickListener{
            val intent: Intent = Intent(this, contador ::class.java)
            startActivity(intent)

            finish()
        }
        btnReset.setOnClickListener{


        }


    }
    private  fun CargarListado()
    {
        if (fileList().contains("datos.txt")) {
            try {
                val archivo = InputStreamReader(openFileInput("datos.txt"))
                val br = BufferedReader(archivo)
                var linea = br.readLine()
                val listado = StringBuilder()//solo para mostrarlo
                while (linea != null) {
                    listado.append(linea + " \n ")

                    linea = br.readLine()
                }
                br.close()
                archivo.close()
                this.txtMultilinea.setText(listado)
            } catch (e: IOException) {
            }
        }

    }
    override fun onStart() {
        super.onStart()
        CargarListado()
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}

