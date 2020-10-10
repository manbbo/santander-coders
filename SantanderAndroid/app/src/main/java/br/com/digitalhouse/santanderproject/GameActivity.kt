package br.com.digitalhouse.santanderproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random

class GameActivity (var random: Int = 0,
                    var contador: Int = 0,
                    var toasts: List<String> = listOf<String>(
                        "Nossa você tem muita sorte", //0
                        "Você tem sorte",             //1
                        "Essa foi por pouco!",        //2
                        "Não foi dessa vez, mas não desista.")) : AppCompatActivity() {
    //=
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        guess.setOnClickListener{
            compara(guess_text.text.toString().toInt())
        }
    }

    override fun onResume() {
        super.onResume()
        mostrarToast("O jogo irá começar!")
    }

    override fun onStart() {
        super.onStart()
        random = (1..10).random() as Int
    }

    private fun compara(number: Int) {
        if (contador > 2)
            mostrarToast(toasts[3])
        else {
            if (number == random) {
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Você ganhou!!!")
                alertDialog.setMessage(toasts[contador])
                alertDialog.setNeutralButton("OK"){_,_ ->
                    Toast.makeText(this,"EBA! Vamos jogar novamente",Toast.LENGTH_SHORT).show()
                    contador = 0
                    random = (0..10).random() as Int
                }
                val dialog = alertDialog.create()
                dialog.show()
            } else {
                mostrarToast("Você errou. Tente novamente...")
                contador++
            }
        }
    }

    private fun mostrarToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}