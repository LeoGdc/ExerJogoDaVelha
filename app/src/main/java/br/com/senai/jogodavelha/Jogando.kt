
package br.com.senai.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.senai.jogodavelha.R.layout.jogando
import android.content.Intent
import android.widget.Button
import android.widget.TextView


class Jogando:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jogando)

        val back = findViewById<Button>(R.id.voltar)
        back.setOnClickListener{
            finish()
        }
    }

}