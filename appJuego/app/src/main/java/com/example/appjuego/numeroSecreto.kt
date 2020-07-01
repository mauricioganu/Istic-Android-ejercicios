package com.example.appjuego

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contador.*
import kotlinx.android.synthetic.main.activity_numero_secreto.*
import org.w3c.dom.Text
import java.io.IOException
import java.io.OutputStreamWriter

class numeroSecreto : AppCompatActivity() {
    val numeroRandom=(Math.random()*10).toInt()
    var  numeroIntentos:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numero_secreto)
        val lbl_Ingreso : TextView =findViewById<TextView>(R.id.lbl_Ingreso)
        val lblNumero :TextView =findViewById<TextView>(R.id.lblNumero)
        val lbl_NumeroIntentos :TextView =findViewById<Button>(R.id.lbl_NumeroIntentos)
        val btn_Otro_Intento :Button =findViewById<Button>(R.id.btn_Otro_Intento)
        val btn_Regresar :Button =findViewById<Button>(R.id.btn_Regresar)
        val btn_Perdio :Button =findViewById<Button>(R.id.btn_Perdio)
        val btn_Descubrir :Button =findViewById<Button>(R.id.btn_Descubrir)
        val btn_ayuda_n :Button =findViewById<Button>(R.id.btn_ayuda_n)
        val btn_guardarIntento :Button =findViewById<Button>(R.id.btn_guardarIntento)
        val btn_historial :Button =findViewById<Button>(R.id.btn_historial)
        btn_historial.setOnClickListener{
            val intent: Intent = Intent(this, guardar_Intentos ::class.java)
            startActivity(intent)

            finish()
        }
        btn_ayuda_n.setOnClickListener{
            val intent:Intent=Intent (this,com.example.appjuego.ayudaNumero::class.java)
            startActivity(intent)
            finish()
        }
        btn_guardarIntento.setOnClickListener{
           try {
                val archivo = OutputStreamWriter(openFileOutput("score_numero.txt", Activity.MODE_APPEND))
                archivo.write(lbl_NumeroIntentos.text.toString()  +"  "  + "\n")
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {

            }
            Toast.makeText(this, "Se ha guardado con éxito", Toast.LENGTH_SHORT).show()

        }
        btn_Otro_Intento.setOnClickListener{
            val intent:Intent=Intent (this,com.example.appjuego.numeroSecreto::class.java)
            startActivity(intent)
            finish()
        }
       btn_Regresar.setOnClickListener{
           val intent:Intent = Intent (this,menuDeJuegos::class.java)
           startActivity(intent)
           finish()
       }
        btn_Perdio.setOnClickListener{


            Toast.makeText(this, "El número era $numeroRandom ", Toast.LENGTH_LONG).show()
            lblNumero.text=numeroRandom.toString()
        }
        btn_Descubrir.setOnClickListener{
            numeroIntentos++
            lbl_NumeroIntentos.text=numeroIntentos.toString()

            if (lbl_Ingreso.text.toString().isEmpty())
            {

                Toast.makeText(this, "Campos vacios ", Toast.LENGTH_LONG).show()
            } else
            {
                if (lbl_Ingreso.text.toString() < 0.toString() )
                {
                    Toast.makeText(this, "Ingresa un número mayor o igual a 0 ", Toast.LENGTH_LONG).show()
                } else
                {
                    if (numeroRandom.toString() == lbl_Ingreso.text.toString())
                    {
                        Toast.makeText(this, "Excelente! Adivinaste el número!", Toast.LENGTH_LONG).show()
                        lblNumero.text=numeroRandom.toString()
                         try {
                             val archivo = OutputStreamWriter(openFileOutput("score_numero.txt", Activity.MODE_APPEND))

                             archivo.write(   "Intentos: " + " " + lbl_NumeroIntentos.toString() + "\n")
                             archivo.flush()
                             archivo.close()
                         } catch (e: IOException) {

                         }
                    }
                    else
                    {
                        if (numeroRandom.toString() < lbl_Ingreso.text.toString())
                        {
                            Toast.makeText(this,"El número es menor",Toast.LENGTH_LONG).show()
                        }
                        else
                        {
                            Toast.makeText(this, "El número es mayor", Toast.LENGTH_LONG).show()
                        }
                    }












            }
            }

        }
    }
}