package br.com.digitalhouse.exercicios.exercicio02

fun main() {

    try {
        val lista = ArrayList<String>(null)
        lista.add("Pato")
        lista.add("Cachorro")
        lista.add("Gato")
        println(lista.get(2))
    }catch (ex: Exception){
        println("Ocorreu uma exeção: ${ex.message}")
        println("Causa: ${ex.cause}")
    }

}