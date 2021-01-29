package com.example.desafiofinal.data

import java.io.Serializable

data class GameTileInfo(var ID : String,
                        var name: String,
                        var year: Int,
                        var photo: String,
                        var description : String) :Serializable {
}