package br.com.digitalhouse.exercicioaula10.exercicio1


// Main
fun main(){
    // Exercício 1
    val pessoa1 = Pessoa("João S", 1114455887)
    val pessoa2 = Pessoa("Maria S",1114455887)

    println(pessoa1 == pessoa2)
    println(pessoa1.equals(pessoa2.RG))
}