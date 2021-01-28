package com.example.desafiofinal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiofinal.R
import com.example.desafiofinal.adapters.GameTileAdapter
import com.example.desafiofinal.api.Storage
import com.example.desafiofinal.data.GameTileInfo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class HomeActivity : AppCompatActivity() {
    private lateinit var rc_view : RecyclerView

    val viewModel by viewModels<HomeViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeViewModel() as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var emptylist :TextView = findViewById(R.id.empty)

        viewModel.getListGames()

        rc_view = findViewById(R.id.rv_games)

        viewModel.listGames.observe(this) {
            //if (!it.isNullOrEmpty()) {
                rc_view.visibility = View.VISIBLE
                emptylist.visibility = View.INVISIBLE
                rc_view.adapter = GameTileAdapter(it, this)
                rc_view.layoutManager = GridLayoutManager(this, 2)
                rc_view.setHasFixedSize(true)
            //} else {
             //   rc_view.visibility = View.INVISIBLE
            //    emptylist.visibility = View.VISIBLE
            //}
        }
        var floating :FloatingActionButton = findViewById(R.id.addgame)

        floating.setOnClickListener {
            startActivity(Intent(this, GameInfoFillActivity()::class.java))
        }
    }


}