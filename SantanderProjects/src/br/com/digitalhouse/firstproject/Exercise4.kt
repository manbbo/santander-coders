package br.com.digitalhouse.firstproject

fun main() {
    firstOneHundredPositive()
}

fun firstOneHundredPositive() {
    for (i in 0..100) {
        if (i % 2 != 0 && i > -1) {
            println(i)
        }
    }
}