package com.example.desafiofinal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.desafiofinal.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var loginbt : Button = findViewById(R.id.login)
        var createbt : Button = findViewById(R.id.create)

        loginbt.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        createbt.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}