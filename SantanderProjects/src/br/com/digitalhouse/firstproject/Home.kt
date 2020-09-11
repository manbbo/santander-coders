package br.com.digitalhouse.firstproject

fun main() {
    println("Oi mundo\n${showName("Andre", "Piton", 24)}\n")
    println("-------------------------------------------------------")
    println("LISTA DE ALUNOS")
    println("-------------------------------------------------------")
    for (i: String in classmatesAndroid()) {
        println(i)
    }
}

fun showName(name: String, surname: String, idade: Int) :String {
    val idadeRecebida = when (idade) {
        0 -> "nao se sabe a idade."
        else -> "tem $idade anos de idade."
    }

    return "$name $surname e $idadeRecebida"
}

fun classmatesAndroid(): ArrayList<String> {
    val listClassmates = arrayListOf<String>()
    listClassmates.add("Vitoria")
    listClassmates.add("Luiz")
    listClassmates.add("Wagenr")
    listClassmates.add("Jones")
    listClassmates.add("Piton")

    return listClassmates
}