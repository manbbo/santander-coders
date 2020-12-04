package br.com.digitalhouse.webservices.services

import android.util.Log
import android.widget.Toast
import br.com.digitalhouse.webservices.secrets.Constants
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyService {
    @GET("comics")
    suspend fun getAllComics(@Query("offset") offset: Int = 0): JsonObject

    @GET("comics/{id}")
    suspend fun getOneComic(@Path("id") comicId: Int): JsonObject
}

class Retrofit() {
    companion object {
        fun getService(): MyService? {
            return try {
                Retrofit.Builder()
                    .baseUrl(Constants().baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient()
                        .newBuilder()
                        .addInterceptor(Intercepter())
                        .build())
                    .build().create(MyService::class.java)
            } catch (e: Exception) {
                Log.i("Service", e.message.toString())
                null
            }
        }
    }
}