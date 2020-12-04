package br.com.digitalhouse.firstproject

fun main() {
    println(isEvenNumber(21))
}

fun isEvenNumber(_number: Int) : Boolean {
    return (_number % 2 == 0)
}