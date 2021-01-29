package com.example.desafiofinal.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.desafiofinal.R
import com.example.desafiofinal.api.Credentials
import com.example.desafiofinal.api.Storage
import com.example.desafiofinal.api.Store
import com.example.desafiofinal.data.GameTileInfo

class GameInfoFillActivity : AppCompatActivity() {
    private val REQUEST_SELECT_IMAGE_IN_ALBUM = 1
    lateinit var imageUri : Uri
    lateinit var gameTileOld : GameTileInfo

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
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_SELECT_IMAGE_IN_ALBUM)
            }
        }

        val saveBt : Button = findViewById(R.id.save)

        saveBt.setOnClickListener {

            if (!title.text.toString().isNullOrEmpty() && !year.text.toString().isNullOrEmpty()) {
                //image store
                val store = Store(title.text.toString().trim().replace(" ", "-"))
                store.uploadFromMemory(image)
                val finalGameInfo = GameTileInfo(title.text.toString().trim(), year.text.toString().toInt(), Credentials().imageURL + "" + title.text.toString().trim().replace(" ", "-") + "?alt=media", description.text.toString())

                // information store
                var storage = Storage(finalGameInfo)

                if (!storage.getInstance()) {
                    storage.addData()
                } else {
                    storage.addData()
                }

                finish()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_SELECT_IMAGE_IN_ALBUM) {
            imageUri = data?.data!!
            val image : ImageView = findViewById(R.id.game_img)

            image.setImageURI(imageUri)
        }
    }
}