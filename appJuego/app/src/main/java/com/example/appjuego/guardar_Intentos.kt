package com.example.appjuego

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_guardar__intentos.*
import kotlinx.android.synthetic.main.activity_guardar_valor_contador.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.time.LocalDate

class guardar_Intentos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardar__intentos)
        val btn_volver : Button =findViewById<Button>(R.id.btn_volver)
        val txt_historial : TextView =findViewById<TextView>(R.id.txt_historial)
        btn_volver.setOnClickListener{
            val intent: Intent = Intent(this, numeroSecreto ::class.java)
            startActivity(intent)

            finish()
        }

    }
    private  fun CargarLista()
    {
        if (fileList().contains("score_numero.txt")) {
            try {
                val archivo = InputStreamReader(openFileInput("score_numero.txt"))
                val br = BufferedReader(archivo)
                var linea = br.readLine()
                val listado = StringBuilder()//solo para mostrarlo
                while (linea != null) {
                    listado.append(linea + " \n ")
                    linea = br.readLine()
                }
                br.close()
                archivo.close()
                this.txt_historial.setText(listado)
            } catch (e: IOException) {
            }
        }

    }
    override fun onStart() {
        super.onStart()
        CargarLista()
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