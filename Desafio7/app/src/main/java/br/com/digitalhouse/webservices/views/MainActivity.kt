package br.com.digitalhouse.webservices.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.digitalhouse.webservices.R
import br.com.digitalhouse.webservices.adapters.ComicAdapter
import br.com.digitalhouse.webservices.adapters.OnClickItemListener
import br.com.digitalhouse.webservices.models.Results
import br.com.digitalhouse.webservices.services.Retrofit
import br.com.digitalhouse.webservices.viewmodels.ComicViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClickItemListener {
    var comicsList = ArrayList<Results>()
    private lateinit var adapter: ComicAdapter

    var offset = 0
    var limit = 20

    private val viewModel by viewModels<ComicViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ComicViewModel(Retrofit.getService()!!, application) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ComicAdapter(comicsList, this)

        rv_comic.adapter = adapter
        rv_comic.layoutManager = GridLayoutManager(this, 2)

        viewModel.getAllComics()
        viewModel.comicsList.observe(this) {
            comicsList.addAll(it.results)
            rv_comic.adapter = ComicAdapter(comicsList, this)
        }

        scroll_view.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                    offset += limit
                    viewModel.getAllComics(offset)
                }
            }
        )
    }

    override fun OnClickItem(position: Int) {
        val comic = comicsList[position]
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("comic", comic.id)
        startActivity(intent)
    }
}