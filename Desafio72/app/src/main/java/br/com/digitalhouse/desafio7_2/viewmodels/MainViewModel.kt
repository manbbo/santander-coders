package br.com.digitalhouse.desafio7_2.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import br.com.digitalhouse.desafio7_2.models.Gastos
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class MainViewModel (app: Application):AndroidViewModel(app) {
    private val context = getApplication<Application>().applicationContext

    fun getListGastos() : ArrayList<Gastos> {
        var listGastos : ArrayList<Gastos> = arrayListOf()
        try {
            val jsonString = context.assets.open("gastos.json")
                    .bufferedReader()
                    .use { it.readText() }

            val jsonArray = JSONArray(jsonString)

            for (i in 0..jsonArray.length()-1) {
                val data = jsonArray.getJSONObject(i)

                var gasto = Gastos(data.getInt("id"),
                        data.getString("desc"),
                        data.getDouble("valor"))

                listGastos.add(gasto)
            }
        } catch (ioExcept: IOException) {
            Log.e("MainViewModel", ioExcept.toString())
        }

        return listGastos
    }
}