
package br.com.senai.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.senai.jogodavelha.R.layout.dificuldade
import android.content.Intent
import android.widget.Button
import android.widget.TextView


class Difficulty:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dificuldade)

        val back = findViewById<Button>(R.id.voltar)
        val easy = findViewById<Button>(R.id.facil)
        val medium = findViewById<Button>(R.id.medio)
        val difficult = findViewById<Button>(R.id.dificil)

        back.setOnClickListener {
            finish()
        }
        easy.setOnClickListener {
            irParaJogando()
        }
        medium.setOnClickListener {
            irParaJogando()
        }
        difficult.setOnClickListener {
            irParaJogando()
        }
    }
    private fun irParaJogando() {

        val player = Intent(this, R.layout.jogando::class.java)
        startActivity(player)
    }
}

