package br.com.digitalhouse.webservices.models

import java.io.Serializable

data class Response(
    var count: Int,
    val limit: Int,
    var offset: Int,
    var results: ArrayList<Results>,
    val total: Int
) : Serializable

