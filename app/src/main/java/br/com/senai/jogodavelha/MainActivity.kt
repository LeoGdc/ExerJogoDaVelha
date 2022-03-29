package br.com.senai.jogodavelha

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Selection
import br.com.senai.jogodavelha.R.layout.activity_main
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.senai.jogodavelha.R.layout.jogando


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jvj = findViewById<Button>(R.id.BT_JvJ)
        val jvC = findViewById<Button>(R.id.BT_JvC)

        jvj.setOnClickListener{

            irParaPlayer()
        }
        jvC.setOnClickListener{

            irParaDifficulty()
        }

    }
    private fun irParaPlayer() {

        val player = Intent(this, jogando::class.java)
        startActivity(player)
    }

    private fun irParaDifficulty(){

        val difficulty = Intent(this, Difficulty::class.java)
        startActivity(difficulty)
    }
}