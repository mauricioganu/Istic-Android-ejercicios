package com.example.appjuego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_guardar_valor_contador.*
import kotlinx.android.synthetic.main.activity_listado_registro.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class listadoRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_registro)
    }

    private  fun CargarListada()
    {
        if (fileList().contains("registros.txt")) {
            try {
                val archivo = InputStreamReader(openFileInput("registros.txt"))
                val br = BufferedReader(archivo)
                var linea = br.readLine()
                val listado = StringBuilder()//solo para mostrarlo
                while (linea != null) {
                    listado.append(linea + " \n ")

                    linea = br.readLine()
                }
                br.close()
                archivo.close()
                this.listar.setText(listado)
            } catch (e: IOException) {
            }
        }

    }
    override fun onStart() {
        super.onStart()
        CargarListada()
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