package br.com.digitalhouse.desafioandroidcore.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.desafioandroidcore.R
import kotlinx.android.synthetic.main.login_body.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login!!.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        btn_register!!.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}