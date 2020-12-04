package br.com.digitalhouse.webservices.models

import java.io.Serializable

data class Results(
    val collectedIssues: List<Any>,
    val collections: List<Any>,
    val dates: List<Date>,
    val description: String,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val format: String,
    val id: Int,
    val images: List<Image>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val resourceURI: String,
    val stories: Stories,
    val textObjects: List<TextObject>,
    val thumbnail: Thumbnail,
    val prices: List<Price>,
    val title: String,
    val upc: String,
    val urls: List<Url>,
    val variantDescription: String,
    val variants: List<Any>
) : Serializable {
}