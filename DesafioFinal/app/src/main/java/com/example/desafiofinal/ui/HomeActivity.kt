package com.example.desafiofinal.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiofinal.R
import com.example.desafiofinal.adapters.GameTileAdapter

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var rc_view : RecyclerView = findViewById(R.id.rv_games)

        //rc_view.adapter = GameTileAdapter()
        rc_view.layoutManager = GridLayoutManager(this, 2)
        rc_view.setHasFixedSize(true)
    }
}