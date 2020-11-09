package br.com.digitalhouse.desafioandroidcore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.desafioandroidcore.R
import br.com.digitalhouse.desafioandroidcore.data.FoodCardInfo

class FoodCardAdapter (private val cardapio: ArrayList<FoodCardInfo>) : RecyclerView.Adapter<FoodCardAdapter.ViewHolder>() {
    class ViewHolder  (item: View) : RecyclerView.ViewHolder(item){
        val tv_name:TextView = item.findViewById(R.id.tv_plate_name)
        val tv_locat:TextView = item.findViewById(R.id.tv_plate_location)
        val tv_close:TextView = item.findViewById(R.id.tv_plate_time_open)
        val img_food:ImageView = item.findViewById(R.id.food_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemView = cardapio[position]
        holder.tv_close.setText(itemView.closesat)
        holder.tv_name.setText(itemView.name)
        holder.tv_locat.setText(itemView.address)
        holder.img_food.setBackgroundResource(itemView.photo)
    }

    override fun getItemCount() = cardapio.size
}