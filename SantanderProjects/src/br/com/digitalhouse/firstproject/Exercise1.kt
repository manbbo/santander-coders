package br.com.digitalhouse.firstproject

fun main() {
    println(greaterThen(-150, -200, -50))
}

fun greaterThen(firstNum: Int, secondNum: Int, thirdNum: Int): Int {
    val listOfArrays = arrayListOf<Int>(firstNum, secondNum, thirdNum)
    var greater = -1000

    for (i in listOfArrays) {
        if (greater < i) {
            greater = i
        }
    }

    return greater
}