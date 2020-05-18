package com.example.appjuego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contador.*

class contador : AppCompatActivity() {
    var contador=0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)
        btnContar.setOnClickListener{
            contador++

            textView.text=contador.toString()

        }

    }
}
