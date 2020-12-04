package br.com.digitalhouse.webservices.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.webservices.models.Response
import br.com.digitalhouse.webservices.services.MyService
import br.com.digitalhouse.webservices.services.Retrofit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ComicViewModel(service: MyService, application: Application) :
    AndroidViewModel(application) {
    val comicsList = MutableLiveData<Response>()
    fun getAllComics(offset: Int = 0) {
        viewModelScope.launch(Dispatchers.Main) {
                try {
                    val response = Retrofit.getService()!!.getAllComics(offset)
                    val results = response.get("data")
                    val comics = Gson().fromJson(
                        results,
                        object : TypeToken<Response>() {}.type
                    ) as Response

                    comicsList.value = comics
                } catch (e: Exception) {
                    Log.i("COMIC VIEW", e.toString())
                }

        }
    }
}
