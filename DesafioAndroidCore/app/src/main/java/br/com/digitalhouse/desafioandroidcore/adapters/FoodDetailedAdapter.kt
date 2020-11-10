package br.com.digitalhouse.desafioandroidcore.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.desafioandroidcore.FoodDetailsActivity
import br.com.digitalhouse.desafioandroidcore.PlateDetailActivity
import br.com.digitalhouse.desafioandroidcore.R
import br.com.digitalhouse.desafioandroidcore.data.FoodCardInfo
import kotlinx.android.synthetic.main.detailed_food_item.view.*

class FoodDetailedAdapter (private val cardapio: ArrayList<FoodCardInfo>) : RecyclerView.Adapter<FoodDetailedAdapter.ViewHolder>() {
    class ViewHolder  (item: View) : RecyclerView.ViewHolder(item){
        val tv_name:TextView = item.findViewById(R.id.tv_plate_name)
        val img_food:ImageView = item.findViewById(R.id.food_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)

        view.food_card.setOnClickListener {
            view.context.startActivity(Intent(parent.context, PlateDetailActivity::class.java))
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemView = cardapio[position]
        holder.tv_name.setText(itemView.name)
        holder.img_food.setBackgroundResource(itemView.photo)
    }

    override fun getItemCount() = cardapio.size
}
