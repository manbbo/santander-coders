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

class DetailViewModel(service: MyService, application: Application) : AndroidViewModel(application) {
    val comicInfo = MutableLiveData<Response>()
    fun getOneComic(comicId: Int) {
        viewModelScope.launch(Dispatchers.Main) {
                try {
                    val response = Retrofit.getService()!!.getOneComic(comicId)
                    val results = response.get("data")
                    val comic = Gson().fromJson(
                        results,
                        object : TypeToken<Response>() {}.type
                    ) as Response
                    comicInfo.value = comic
                } catch (e: Exception) {
                    Log.i("DETAIL VIEW", e.toString())
                }
        }

    }
}