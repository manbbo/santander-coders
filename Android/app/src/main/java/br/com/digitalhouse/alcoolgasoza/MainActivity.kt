package br.com.digitalhouse.alcoolgasoza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        comparar.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(v: View?) {

                    if (etanol.text.toString().toFloat() <
                        (gasosa.toString().toFloat() * 0.7)) {
                        compre.setImageResource(R.drawable.abasteca_etanol)

                    } else {
                        compre.setImageResource(R.drawable.abasteca_gasolina)
                    }
                }})
    }
}