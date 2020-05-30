package com.example.appjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contador.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnIr.setOnClickListener {
            val intent: Intent =Intent(this, QuienSoy::class.java)
            startActivity(intent)

            }
        btnRegistrar.setOnClickListener {
            val intent: Intent =Intent(this, registro ::class.java)
            startActivity(intent)

        }

        }
    }

