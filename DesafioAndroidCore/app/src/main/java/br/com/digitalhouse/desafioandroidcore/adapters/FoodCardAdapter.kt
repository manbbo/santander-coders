package br.com.digitalhouse.desafioandroidcore.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.desafioandroidcore.FoodDetailsActivity
import br.com.digitalhouse.desafioandroidcore.R
import br.com.digitalhouse.desafioandroidcore.data.FoodCardInfo
import kotlinx.android.synthetic.main.food_item.view.*

class FoodCardAdapter (private val cardapio: ArrayList<FoodCardInfo>) : RecyclerView.Adapter<FoodCardAdapter.ViewHolder>() {
    class ViewHolder  (item: View) : RecyclerView.ViewHolder(item){
        val tv_name:TextView = item.findViewById(R.id.tv_plate_name)
        val tv_locat:TextView = item.findViewById(R.id.tv_plate_location)
        val tv_close:TextView = item.findViewById(R.id.tv_plate_time_open)
        val img_food:ImageView = item.findViewById(R.id.food_image)
        val card_food:CardView = item.findViewById(R.id.food_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)

        view.food_card.setOnClickListener {
            view.context.startActivity(Intent(parent.context, FoodDetailsActivity::class.java))
        }

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