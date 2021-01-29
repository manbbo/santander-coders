package com.example.desafiofinal.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
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

            db.collection("games").document(gameTile!!.name.toUpperCase())
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

            db.collection("games").document(gameTile!!.name.toUpperCase())
                    .set(game, SetOptions.merge())
        }
    }
    
    fun getInstance() : Boolean {
        var instanceFound = false
        db.collection("games")
                .document(gameTile!!.name.toUpperCase())
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

    fun getInstances() : MutableLiveData<MutableList<GameTileInfo>> {

        var gameMap =  MutableLiveData<MutableList<GameTileInfo>>()
        var gamelistaux : MutableList<GameTileInfo> = arrayListOf()

        db.collection("games")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("FIRESTORE", "${document.id} => ${document.data}")

                    var gameTile = GameTileInfo(document.data["name"].toString(),
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

    fun deleteData() {
        if (gameTile != null) {
            val game = hashMapOf(
                "name" to gameTile!!.name,
                "year" to gameTile!!.year,
                "description" to gameTile!!.description,
                "image" to gameTile!!.photo
            )
            db.collection("games").document(gameTile!!.name.toUpperCase())
                .delete()
                .addOnSuccessListener { Log.d("FIRESTORE", "DocumentSnapshot successfully deleted!") }
                .addOnFailureListener { e -> Log.w("FIRESTORE", "Error deleting document", e) }
        }
    }
}