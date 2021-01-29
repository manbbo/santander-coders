package com.example.desafiofinal.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafiofinal.api.Storage
import com.example.desafiofinal.data.GameTileInfo

class HomeViewModel() : ViewModel (){
    var listGames = MutableLiveData<MutableList<GameTileInfo>>()

    fun getListGames() {
        listGames = Storage(null).getInstances()
    }
}