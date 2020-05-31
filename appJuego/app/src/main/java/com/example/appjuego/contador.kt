package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ayuda_contador.*
import kotlinx.android.synthetic.main.activity_contador.*

class contador : AppCompatActivity() {
    var contador_contador=0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)
        btnContar.setOnClickListener{
            contador_contador ++

            textView.text=contador_contador.toString()

        }
        btnReset.setOnClickListener{
            contador_contador=0
            textView.text=contador_contador.toString()
        }
        btn_ayuda_c.setOnClickListener{
        val intent: Intent = Intent(this, ayudaContador ::class.java)
        startActivity(intent)


    }

    }
}
