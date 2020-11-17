package br.com.digitalhouse.desafio7_2.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.digitalhouse.desafio7_2.models.Filme
import br.com.digitalhouse.desafio7_2.models.Gastos
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieViewModel(app: Application): AndroidViewModel(app) {
    private val context = getApplication<Application>().applicationContext

    fun getListFilmes(): List<Filme>{

        val jsonString = context.assets.open("filmes.json")
                .bufferedReader()
                .use { it.readText() }

        return Gson().fromJson(jsonString, object : TypeToken<List<Filme>>(){}.type)
    }
}