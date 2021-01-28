package com.example.desafiofinal.api

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import androidx.core.app.ActivityCompat.startActivityForResult
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.example.desafiofinal.api.Credentials
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream

class Storage {
    var store = Firebase.storage(Credentials().URL)
    var storageRef = store.reference
    var imagesRef = storageRef.child("image")

    fun uploadFromMemory(imageView : ImageView) : String {
        var imagePath = ""
// Get the data from an ImageView as bytes
        imageView.isDrawingCacheEnabled = true
        imageView.buildDrawingCache()
        val bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        var uploadTask = imagesRef.putBytes(data)
        uploadTask.addOnFailureListener {
            // Handle unsuccessful uploads
        }.addOnSuccessListener { taskSnapshot ->
            // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
            // ...
            imagePath = taskSnapshot.metadata!!.path
        }

        return imagePath
    }
}