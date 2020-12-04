package br.com.digitalhouse.webservices.views

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.digitalhouse.webservices.R
import br.com.digitalhouse.webservices.models.Response
import br.com.digitalhouse.webservices.services.Retrofit
import br.com.digitalhouse.webservices.viewmodels.DetailViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.comic.*
import java.text.SimpleDateFormat
import java.util.*


class DetailActivity : AppCompatActivity() {
    private lateinit var comicResponse: Response
    private val viewModel by viewModels<DetailViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return DetailViewModel(Retrofit.getService()!!, application) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        backBt.setOnClickListener { onBackPressed() }

        try {
            viewModel.getOneComic(intent.getIntExtra("comic", 0))
        } catch (e: Exception) {
            Log.i("GETTING ONE COMIC", e.message.toString())
            Toast.makeText(this, "Failed to connect", Toast.LENGTH_LONG).show()
        }

        viewModel.comicInfo.observe(this) {
            comicResponse = it
            val comic = comicResponse.results[0]

            comic_title.text = comic.title
            comic_descr.text = comic.description

            val dateFormat = SimpleDateFormat("MMMM dd, yyyy")
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
            val date = dateFormat.format(simpleDateFormat.parse((comic.dates.find { s -> s.type == "focDate" })?.date.toString()))

            comic_published.text = date
            comic_price.text = comic.prices[0].price.toString()
            comic_pages.text = comic.pageCount.toString()

            Glide.with(this)
                .load("${comic.thumbnail.path}.${comic.thumbnail.extension}")
                .centerCrop()
                .placeholder(R.drawable.marvel_logo)
                .error(R.drawable.raster)
                .fallback(R.drawable.raster)
                .into(iv_comic)

            Glide.with(this)
                .load("${comic.images[0].path}.${comic.images[0].extension}")
                .placeholder(R.drawable.marvel_logo)
                .error(R.drawable.raster)
                .fallback(R.drawable.raster)
                .into(iv_bkg)
        }
    }
}