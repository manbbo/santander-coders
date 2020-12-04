package br.com.digitalhouse.webservices.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.webservices.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        loginbt.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        createBt.setOnClickListener {
            startActivity(Intent(this, CreateActivity::class.java))
        }
    }
}