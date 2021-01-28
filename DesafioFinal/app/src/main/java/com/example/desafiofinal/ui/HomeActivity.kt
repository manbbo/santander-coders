package com.example.desafiofinal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiofinal.R
import com.example.desafiofinal.adapters.GameTileAdapter
import com.example.desafiofinal.data.GameTileInfo
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {
    private lateinit var rc_view : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rc_view = findViewById(R.id.rv_games)
        rc_view.adapter = GameTileAdapter(defaultListGameTileInfo(),  this)
        rc_view.layoutManager = GridLayoutManager(this, 2)
        rc_view.setHasFixedSize(true)

        var floating :FloatingActionButton = findViewById(R.id.addgame)

        floating.setOnClickListener {
            startActivity(Intent(this, GameInfoFillActivity()::class.java))
        }
    }

    private fun initRecycler(listGameTiles: ArrayList<GameTileInfo>){

    }

    private fun defaultListGameTileInfo() = arrayListOf(
        GameTileInfo("Cimento",2019, "https://phillyvoice-production.s3.amazonaws.com/media/images/iStock_71729003_MEDIUM.2e16d0ba.fill-735x490.jpg", "Um cimento" ),
        GameTileInfo("Cimento",2019, "https://phillyvoice-production.s3.amazonaws.com/media/images/iStock_71729003_MEDIUM.2e16d0ba.fill-735x490.jpg", "Um cimento" ),
        GameTileInfo("Cimento",2019, "https://phillyvoice-production.s3.amazonaws.com/media/images/iStock_71729003_MEDIUM.2e16d0ba.fill-735x490.jpg", "Um cimento" ),
        GameTileInfo("Cimento",2019, "https://phillyvoice-production.s3.amazonaws.com/media/images/iStock_71729003_MEDIUM.2e16d0ba.fill-735x490.jpg", "Um cimento" ),
        GameTileInfo("Cimento",2019, "https://phillyvoice-production.s3.amazonaws.com/media/images/iStock_71729003_MEDIUM.2e16d0ba.fill-735x490.jpg", "Um cimento" ),
        GameTileInfo("Cimento",2019, "https://phillyvoice-production.s3.amazonaws.com/media/images/iStock_71729003_MEDIUM.2e16d0ba.fill-735x490.jpg", "Um cimento" ),
        GameTileInfo("Cimento",2019, "https://phillyvoice-production.s3.amazonaws.com/media/images/iStock_71729003_MEDIUM.2e16d0ba.fill-735x490.jpg", "Um cimento" ),
    )

}