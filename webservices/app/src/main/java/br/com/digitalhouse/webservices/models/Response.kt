package br.com.digitalhouse.webservices.models

data class Response(
    var count: Int,
    val limit: Int,
    var offset: Int,
    var results: ArrayList<Results>,
    val total: Int
)