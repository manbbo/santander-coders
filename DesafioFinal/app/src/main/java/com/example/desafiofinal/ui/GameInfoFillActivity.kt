package com.example.desafiofinal.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.desafiofinal.R
import com.example.desafiofinal.data.GameTileInfo

class GameInfoFillActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_info_fill)

        val bundle: Bundle? = intent.extras
        val game = bundle?.getSerializable("game") as? GameTileInfo

        if (game != null) {
            val title : EditText = findViewById(R.id.game_nm)
            val image: ImageView = findViewById(R.id.game_img)
            val year: EditText = findViewById(R.id.game_yr)
            val description: EditText = findViewById(R.id.game_descr)

            title.setText(game.name)
            year.setText(game.year.toString())
            description.setText(game.description)

            Glide.with(this)
                .load(game.photo)
                .placeholder(R.drawable.ic_baseline_photo_camera_24)
                .into(image)
        }
    }
}