package br.com.digitalhouse.exercicios.exercicio01

fun main() {
    val lista = ArrayList<String>()
    lista.add("Pato")
    lista.add("Cachorro")
    lista.add("Gato")
    try {
        println(lista.get(3))
    }catch (ex: Exception){
        println("Ocorreu uma exeção: ${ex.message}")
        ex.stackTrace
    }
}