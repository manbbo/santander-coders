package com.example.snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.toolbar.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        setSupportActionBar(my_toolbar)
        my_toolbar.title = "CADASTRAR"
        my_toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_backbt)
    }
}