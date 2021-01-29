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
import com.google.firebase.firestore.ktx.toObject

class GameInfoFillActivity : AppCompatActivity() {
    private val REQUEST_SELECT_IMAGE_IN_ALBUM = 1
    lateinit var imageUri : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_info_fill)

        val bundle: Bundle? = intent.extras
        var game = bundle?.getSerializable("game") as? GameTileInfo

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
                    if (game == null)
                        game = GameTileInfo(title.text.toString().trim().toLowerCase().replace(" ", "-"),
                                title.text.toString().trim(), year.text.toString().toInt(),
                            Credentials().imageURL + "" + title.text.toString().trim().toLowerCase().replace(" ", "-") + "?alt=media",
                            description.text.toString().trim())
                    else {
                        game!!.name = title.text.toString().trim()
                        //game!!.ID = (game!!.ID) ? title.text.toString().trim() : title.text.toString().trim()
                        game!!.photo = Credentials().imageURL + "" + game!!.ID + "?alt=media"
                        game!!.year = year.text.toString().toInt()
                        game!!.description = description.text.toString().trim()
                    }

                val store = Store(game!!.ID)
                store.uploadFromMemory(image)

                // information store
                var storage = Storage(game)

                if (game!!.ID.isNullOrEmpty()) {
                     storage.addData()
                } else {
                        storage.mergeData()
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