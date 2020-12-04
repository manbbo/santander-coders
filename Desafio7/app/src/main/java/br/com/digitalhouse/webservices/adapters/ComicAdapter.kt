package br.com.digitalhouse.webservices.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.webservices.R
import br.com.digitalhouse.webservices.models.Results
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.comic.view.*

class ComicAdapter(
    private val comics: ArrayList<Results>,
    val listener: OnClickItemListener
) : RecyclerView.Adapter<ComicAdapter.ComicView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicView {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.comic, parent, false)
        return ComicView(itemView)
    }

    override fun onBindViewHolder(holder: ComicView, position: Int) {
        val comic = comics[position]
        holder.name.text = "${comic.title}"

        Glide.with(holder.imgCover.context)
            .load("${comic.thumbnail.path}.${comic.thumbnail.extension}")
            .placeholder(R.drawable.marvel_logo)
            .error(R.drawable.raster)
            .fallback(R.drawable.raster)
            .into(holder.imgCover)
    }

    inner class ComicView(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
            val imgCover: ImageView = itemView.cover
            val name: TextView = itemView.title

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
                listener.OnClickItem(position)
        }
    }

    override fun getItemCount() = comics.size
}

interface OnClickItemListener {
    fun OnClickItem(position: Int)
}