package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_numero_secreto.*
import org.w3c.dom.Text

class numeroSecreto : AppCompatActivity() {
    val numeroRandom=(Math.random()*10).toInt()
    var numeroIntentos:Int=0
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

            lblNumero.text=numeroRandom.toString()
            Toast.makeText(this, "El número era $numeroRandom ", Toast.LENGTH_LONG).show()
        }
        btn_Descubrir.setOnClickListener{
            numeroIntentos++
            lbl_NumeroIntentos.text=numeroIntentos.toString()

            if (lbl_Ingreso.text.toString().isEmpty())
            {

                Toast.makeText(this, "Campos vacios ", Toast.LENGTH_LONG).show()
            } else
            {
                if (lbl_Ingreso.text.toString() <= 0.toString() )
                {
                    Toast.makeText(this, "Ingresa un número mayor a 0 ", Toast.LENGTH_LONG).show()
                } else
                {
                    if (lbl_Ingreso.text.toString() < 10.toString())
                    {
                        Toast.makeText(this, "Tu número es menor ", Toast.LENGTH_LONG).show()
                    } else
                    {
                        Toast.makeText(this, "Tu numero es mayor  ", Toast.LENGTH_LONG).show()
                    }
                }
                if (numeroRandom.toString() == lbl_Ingreso.text.toString())

                    {
                        Toast.makeText(this, "Acertaste!", Toast.LENGTH_LONG).show()
                        lblNumero.text=numeroRandom.toString()
                    }












            }
            }

        }
    }
