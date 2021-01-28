package com.example.desafiofinal.api

import android.content.Intent
import androidx.core.app.ActivityCompat.startActivityForResult
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.example.desafiofinal.api.Credentials
import com.google.firebase.storage.StorageReference

class Storage {
    fun beginStore() {
        var store = Firebase.storage(Credentials().URL)
        var storageRef = store.reference
        var imagesRef: StorageReference? = storageRef.child("image")

    }
}