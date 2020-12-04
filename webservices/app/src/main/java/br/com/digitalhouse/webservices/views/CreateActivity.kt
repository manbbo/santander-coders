package br.com.digitalhouse.webservices.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.webservices.R
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_create)
        title = "Register"
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        savebt.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}