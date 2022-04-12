
package br.com.senai.jogodavelha

import android.appwidget.AppWidgetHostView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.senai.jogodavelha.R.layout.jogando
import android.content.Intent
import android.media.Image
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast


class Jogando:AppCompatActivity() {
    var gameover:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jogando)

        //////////////////////////////////botão de voltar///////////////////////////////////////////
        val back = findViewById<Button>(R.id.voltar)
        back.setOnClickListener{
            finish()
        }
    }
    /////////////////////////////////////resetando///////////////////////////////////////////////////
    fun reset(){
        finish();
        startActivity(this.intent);
    }
    ////////////////////////////////////setando id nos buttons///////////////////////////////////////
    fun btClick(view: View){
        val btSelected = view as ImageButton
        var celID = 0

        when(btSelected.id){
            R.id.bu1 ->celID = 1
            R.id.bu2 ->celID = 2
            R.id.bu3 ->celID = 3
            R.id.bu4 ->celID = 4
            R.id.bu5 ->celID = 5
            R.id.bu6 ->celID = 6
            R.id.bu7 ->celID = 7
            R.id.bu8 ->celID = 8
            R.id.bu9 ->celID = 9
        }
        ////////////////////////////verificando se acabou o game/////////////////////////
        if (gameover == false){
            playGame(celID, btSelected )
        } else {
            Handler().postDelayed({reset()}, 10)
        }

    }

    ////////////////////////arrays para guardar a jogadas de cada jogador//////////////////
    var player1 = ArrayList<Int>()
    var player2 = ArrayList <Int>()
    //turno do jogador
    var activePlayer = 1

    ////////////////////////////////////////rodando jogo////////////////////////////////////
    fun playGame (celID:Int, btSelected:ImageButton) {

        if (activePlayer == 1) {
            btSelected.setImageResource(R.drawable.x)
            player1.add(celID)
            activePlayer = 2
        } else {
            btSelected.setImageResource(R.drawable.circle)
            player2.add(celID)
            activePlayer = 1

        }
        btSelected.isEnabled = false
        checkWinner()
    }
//////////////////////////////// /////////verificando quem ganhou//////////////////////////////
    fun checkWinner (){
        var winner = -1

        ///////////////////////////////////////////Horizontal////////////////////////////////
        //horizontal 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        //horizontal 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        //horizontal 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }
        ////////////////////////////////////Vertical//////////////////////////////////////////

        //vertical 1
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner = 2
        }
        //vertical 2
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner = 2
        }
        //vertical 3
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner = 2
        }
        /////////////////////////////////////////Diagonal///////////////////////////////////////////////

        //Diagonal 1
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner = 2
        }
        //vDiagonal 2
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winner = 2
        }
        //////////////////////////////////////////winner////////////////////////////////////////////////
        if(winner!=-1){
            if(winner ==1){
                Toast.makeText(this, "Player 1 Win the Games!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Player 2 Win the Games!" , Toast.LENGTH_SHORT).show()
            }
            gameover = true
        }
    }


}