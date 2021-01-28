package com.example.desafiofinal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.desafiofinal.R
import com.example.desafiofinal.data.GameTileInfo

class GameInfoFillActivity : AppCompatActivity() {
    private val REQUEST_TAKE_PHOTO = 0
    private val REQUEST_SELECT_IMAGE_IN_ALBUM = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_info_fill)

        val bundle: Bundle? = intent.extras
        val game = bundle?.getSerializable("game") as? GameTileInfo

        val title : EditText = findViewById(R.id.game_nm)
        val image: ImageView = findViewById(R.id.game_img)
        val year: EditText = findViewById(R.id.game_yr)
        val description: EditText = findViewById(R.id.game_descr)

        if (game != null) {
            title.setText(game.name)
            year.setText(game.year.toString())
            description.setText(game.description)

            Glide.with(this)
                .load(game.photo)
                .placeholder(R.drawable.ic_baseline_photo_camera_24)
                .into(image)
        }

        image.setOnClickListener{
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_SELECT_IMAGE_IN_ALBUM)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_SELECT_IMAGE_IN_ALBUM) {
            val imageUri = data?.data
            val image : ImageView = findViewById(R.id.game_img)

            image.setImageURI(imageUri)
        }
    }
}