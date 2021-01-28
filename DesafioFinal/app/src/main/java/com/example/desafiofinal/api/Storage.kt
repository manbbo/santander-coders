package com.example.desafiofinal.api

import android.util.Log
import com.example.desafiofinal.data.GameTileInfo
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Storage (var gameTile : GameTileInfo?) {
    // Access a Cloud Firestore instance from your Activity
    val db = Firebase.firestore

    fun addData() {
        if (gameTile != null) {
            val game = hashMapOf(
                    "name" to gameTile!!.name,
                    "year" to gameTile!!.year,
                    "description" to gameTile!!.description,
                    "image" to gameTile!!.photo
            )

            db.collection("games").document(gameTile!!.name)
                    .set(game)
                    .addOnSuccessListener { documentReference ->
                        Log.d("FIRESTORE", "DocumentSnapshot successfully written!")
                    }
                    .addOnFailureListener { e ->
                        Log.w("FIRESTORE", "Error adding document", e)
                    }
        }
    }

    fun mergeData() {
        if (gameTile != null) {
            val game = hashMapOf(
                    "name" to gameTile!!.name.replace("-", " "),
                    "year" to gameTile!!.year,
                    "description" to gameTile!!.description,
                    "image" to gameTile!!.photo
            )

            db.collection("games").document(gameTile!!.name)
                    .set(game, SetOptions.merge())
        }
    }
    
    fun getInstance() : Boolean {
        var instanceFound = false
        db.collection("games")
                .document(gameTile!!.name)
                .get()
                .addOnSuccessListener { result ->
                    if (result != null) {
                        Log.d("FIRESTORE", "DocumentSnapshot data: ${result.data}")
                        instanceFound = true
                    } else {
                        Log.d("FIRESTORE", "No such document")
                        instanceFound = false
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("FIRESTORE", "Error getting documents.", exception)
                    instanceFound = false
                }

        return instanceFound
    }
}