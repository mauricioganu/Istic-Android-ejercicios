package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_ayuda_contador.*

class ayudaContador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda_contador)
        val btnVolver : Button =findViewById<Button>(R.id.btnVolver)

        btnVolver.setOnClickListener{
            val intent: Intent = Intent(this, contador ::class.java)
            startActivity(intent)
            finish()


        }
    }
}
