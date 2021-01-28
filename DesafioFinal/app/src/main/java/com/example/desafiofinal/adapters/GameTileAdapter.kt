package com.example.desafiofinal.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.desafiofinal.R
import com.example.desafiofinal.data.GameTileInfo
import com.example.desafiofinal.ui.GameDetailsActivity
import kotlinx.android.synthetic.main.activity_game_details.view.*

class GameTileAdapter (private val games: ArrayList<GameTileInfo>,
                       var ctx: Context) : RecyclerView.Adapter<GameTileAdapter.ViewHolder>() {
    class ViewHolder  (item: View) : RecyclerView.ViewHolder(item){

        val tv_name: TextView = item.findViewById(R.id.tv_game_name)
        val tv_year:TextView = item.findViewById(R.id.tv_game_year)
        val img_game: ImageView = item.findViewById(R.id.game_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(ctx).inflate(R.layout.game_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemView = games[position]
        holder.itemView.tag = position
        holder.tv_year.setText(itemView.year.toString())
        holder.tv_name.setText(itemView.name)

        holder.itemView.setOnClickListener {
            var intent = Intent(ctx, GameDetailsActivity::class.java)
            var item = games[position]
            intent.putExtra("game", item)
            ctx.startActivity(intent)
        }

        Glide.with(ctx)
           .load(itemView.photo)
           .placeholder(R.drawable.ic_baseline_photo_camera_24)
           .transition(DrawableTransitionOptions.withCrossFade())
           .into(holder.img_game)
        //.setBackgroundResource(itemView.photo)

    }

    override fun getItemCount() = games.size
}