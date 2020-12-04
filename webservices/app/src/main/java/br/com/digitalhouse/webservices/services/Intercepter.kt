package br.com.digitalhouse.webservices.services

import br.com.digitalhouse.webservices.secrets.Constants
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest

class Intercepter :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val ts: String = (System.currentTimeMillis() / 1000).toString();
        val s = ts + Constants().privatekey + Constants().publickey
        val m = MessageDigest.getInstance("MD5")
        m.update(s.toByteArray(), 0, s.length);

        var hash: String = BigInteger(1, m.digest()).toString(16)

        val request = chain.request()
        val url = request.url().newBuilder()
            .addQueryParameter("ts", ts)
            .addQueryParameter("apikey", Constants().publickey)
            .addQueryParameter("hash", hash)
            .build()

        val newRequest = request.newBuilder()
            .url(url)
            .build()

        return chain.proceed(newRequest)
    }
}