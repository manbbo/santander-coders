package br.com.digitalhouse.firstproject

fun main() {
    println(analyzeText("Empada", " Empada "))
}

fun analyzeText(first: String, second: String): Boolean {
    return (first.trim() != second.trim())
}