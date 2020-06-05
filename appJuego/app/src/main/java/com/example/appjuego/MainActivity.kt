package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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


            val intent1: Intent =Intent(this, QuienSoy::class.java)
            startActivity(intent1)
            finish()
            }


        }

    }
}

