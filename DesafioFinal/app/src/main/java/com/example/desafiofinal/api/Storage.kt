package com.example.desafiofinal.api

import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.example.desafiofinal.api.Credentials

class Storage {
    var storage = Firebase.storage(Credentials().URL)
}