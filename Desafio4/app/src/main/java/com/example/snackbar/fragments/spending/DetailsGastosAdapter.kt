package com.example.snackbar.fragments.spending

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.snackbar.R
import com.example.snackbar.domain.Gastos
import kotlinx.android.synthetic.main.item_gastos.view.*

class DetailsGastosAdapter(private val listGastos: ArrayList<Gastos>) :RecyclerView.Adapter<DetailsGastosAdapter.DetailsViewHolder>() {
    class DetailsViewHolder (item: View) : RecyclerView.ViewHolder(item) {
        val tv_descr : TextView = item.findViewById(R.id.item_descr)
        val tv_cat : TextView = item.findViewById(R.id.item_cat)
        val tv_date : TextView = item.findViewById(R.id.item_date)
        val tv_valor : TextView = item.findViewById(R.id.item_valor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_gastos, parent, false)
        return DetailsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val itemView = listGastos[position]
        holder.tv_descr.setText(itemView.descricao)
        holder.tv_cat.setText(itemView.categoria)
        holder.tv_date.setText(itemView.data.toString())
        holder.tv_valor.setText(itemView.valor.toString())
    }

    override fun getItemCount() = listGastos.size
}