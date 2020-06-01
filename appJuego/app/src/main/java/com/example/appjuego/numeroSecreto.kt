package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_numero_secreto.*

class numeroSecreto : AppCompatActivity() {
    val numeroRandom=(Math.random()*10).toInt()
    var numeroIntentos:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numero_secreto)
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
