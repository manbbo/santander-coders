package br.com.digitalhouse.webservices.models

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)