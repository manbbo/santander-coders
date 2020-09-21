package br.com.digitalhouse.exercicioaula10.exercicio4

fun main(){
    // Exercício 4
    val funcionarios = arrayOf(
            Funcionario("Leandro", 1),
            Funcionario("José", 2),
            Funcionario("Fulano", 3),
            Funcionario("Fulaninho", 4)
    )

    val funcionario = Funcionario("Leandroa", 1)

    println("O funcionario está na lista? ${funcionarios.contains(funcionario)}")
}