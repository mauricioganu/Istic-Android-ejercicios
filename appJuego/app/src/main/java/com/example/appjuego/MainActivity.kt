package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnRegistrar : Button =findViewById<Button>(R.id.btnRegistrar)
        val btnIr :Button =findViewById<Button>(R.id.btnIr)
        val lblUsuario : EditText =findViewById<EditText>(R.id.lblUsuario)
        val lblPass :TextView =findViewById<TextView>(R.id.lblPass)
        
        btnRegistrar.setOnClickListener {
            val intent2: Intent =Intent(this, registro ::class.java)
            startActivity(intent2)
            finish()

        }
        btnIr.setOnClickListener {
            if (lblUsuario.text.toString().isEmpty() or lblPass.text.toString().isEmpty())
        {

            Toast.makeText(this, "Campos vacios ", Toast.LENGTH_LONG).show()
        }


            else {


            UsuarioQuePuedeLogearse()
            }


        }

    }
    private fun UsuarioQuePuedeLogearse() {

        (fileList().contains("registros.txt"))
        try {

            var banderaUsuario: String = "no"

            val archivo = InputStreamReader(openFileInput("registros.txt"))
            val br = BufferedReader(archivo)
            var linea = br.readLine()
            while (linea != null) {

                val arrayDatos = linea.split("=>")
                if (arrayDatos[2] == lblUsuario.text.toString() && arrayDatos[3] == lblPass.text.toString()) {

                    banderaUsuario = "si"
                    val Usuario_Logueado = lblUsuario.text.toString()
                    val intent: Intent = Intent(this, QuienSoy::class.java)

                    intent.putExtra("mail", Usuario_Logueado)
                    startActivity(intent)
                    break

                }


                linea = br.readLine()
            }

            if (banderaUsuario == "no") {
                Toast.makeText(this, "Usuario y/o contraseña incorecto ", Toast.LENGTH_LONG).show()

            }

            br.close()
            archivo.close()

        } catch (e: IOException) {
        }
    }
}

