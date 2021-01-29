package com.example.desafiofinal.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.desafiofinal.data.GameTileInfo
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class Storage (var gameTile : GameTileInfo?) {
    // Access a Cloud Firestore instance from your Activity
    val db = Firebase.firestore

    fun addData() {
            val game = hashMapOf(
                    "id" to gameTile!!.name.toLowerCase().replace(" ", "-"),
                    "name" to gameTile!!.name,
                    "year" to gameTile!!.year,
                    "description" to gameTile!!.description,
                    "image" to gameTile!!.photo
            )

            db.collection("games").document(gameTile!!.name.toLowerCase())
                    .set(game)
                    .addOnSuccessListener { documentReference ->
                        Log.d("FIRESTORE", "DocumentSnapshot successfully written!")
                    }
                    .addOnFailureListener { e ->
                        Log.w("FIRESTORE", "Error adding document", e)
                    }
    }

    fun mergeData() {
        val game = hashMapOf(
            "id" to gameTile!!.ID,
            "image" to gameTile!!.photo,
                "name" to gameTile!!.name,
                    "year" to gameTile!!.year,
                    "description" to gameTile!!.description
            )

            db.collection("games").document(gameTile!!.ID.toLowerCase())
                    .set(game, SetOptions.merge())
    }
    
    fun getInstance() : Task<DocumentSnapshot> {
        return db.collection("games")
            .document(gameTile!!.ID.toLowerCase())
            .get()
            .addOnSuccessListener { result ->
                Log.d("GETINSTANCE", "getInstance: $result")
            }
            .addOnFailureListener { exception ->
                Log.w("GETINSTANCE", "Error getting documents.", exception)
            }
    }

    fun getInstances() : MutableLiveData<MutableList<GameTileInfo>> {

        var gameMap =  MutableLiveData<MutableList<GameTileInfo>>()
        var gamelistaux : MutableList<GameTileInfo> = arrayListOf()

        db.collection("games")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("FIRESTORE", "${document.id} => ${document.data}")

                    var gameTile = GameTileInfo(document.id,
                        document.data["name"].toString(),
                        document.data["year"].toString().toInt(),
                        document.data["image"].toString(),
                        document.data["description"].toString())

                    gamelistaux.add(gameTile)
                }
                gameMap.value = gamelistaux
            }
            .addOnFailureListener { exception ->
                Log.d("FIRESTORE", "Error getting documents: ", exception)
            }

        return gameMap
    }
}