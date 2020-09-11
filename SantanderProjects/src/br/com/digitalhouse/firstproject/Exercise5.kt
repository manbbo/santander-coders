package br.com.digitalhouse.firstproject

fun main() {
    println(isGreaterThen(5, 1, 6, 7))
}

fun isGreaterThen(numA: Int, numB: Int, numC: Int, numD: Int): Boolean {
    return (numA > numC && numA > numD || numB > numC && numB > numD)
}