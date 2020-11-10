package br.com.digitalhouse.desafioandroidcore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.desafioandroidcore.R
import kotlinx.android.synthetic.main.activity_food_details.*

class PlateDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plate_detail)

        bt_back.setOnClickListener {
            finish()
        }
    }
}