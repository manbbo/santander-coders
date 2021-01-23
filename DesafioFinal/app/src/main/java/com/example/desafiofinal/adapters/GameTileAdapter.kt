package com.example.desafiofinal.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiofinal.R
import com.example.desafiofinal.data.GameTileInfo
import com.example.desafiofinal.ui.GameDetailsActivity
import kotlinx.android.synthetic.main.activity_game_details.view.*

class GameTileAdapter (private val games: ArrayList<GameTileInfo>) : RecyclerView.Adapter<GameTileAdapter.ViewHolder>() {
    class ViewHolder  (item: View) : RecyclerView.ViewHolder(item){
        val tv_name: TextView = item.findViewById(R.id.tv_game_name)
        val tv_year:TextView = item.findViewById(R.id.tv_game_year)
        val img_game: ImageView = item.findViewById(R.id.game_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false)

        view.game_card.setOnClickListener {
            view.context.startActivity(Intent(parent.context, GameDetailsActivity::class.java))
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemView = games[position]
        holder.tv_year.setText(itemView.year)
        holder.tv_name.setText(itemView.name)
        holder.img_game.setBackgroundResource(itemView.photo)

    }

    override fun getItemCount() = games.size
}