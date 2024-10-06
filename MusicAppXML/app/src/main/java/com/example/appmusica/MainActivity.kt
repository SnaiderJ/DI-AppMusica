package com.example.appmusica

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var botonPlay: ImageButton
    private lateinit var botonPause: ImageButton
    private var reproduciendo: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonPlay = findViewById(R.id.imageButtonPlay)
        botonPause = findViewById(R.id.imageButtonPause)

        botonPlay.setOnClickListener {
            reproduciendo = true
            botonVisible()
        }

        botonPause.setOnClickListener {
            reproduciendo = false
            botonVisible()
        }
    }

    private fun botonVisible() {
        if (!reproduciendo) {
            botonPlay.visibility = View.VISIBLE
            botonPause.visibility = View.INVISIBLE
        } else {
            botonPlay.visibility = View.INVISIBLE
            botonPause.visibility = View.VISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("reproduciendo", reproduciendo)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        reproduciendo = savedInstanceState.getBoolean("reproduciendo", false)
        botonVisible()
    }
}