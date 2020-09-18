package br.com.digitalhouse.exercicioaula10.exercicio4

fun main() {
    val alunos = listOf(Aluno1("Thalita", 1), Aluno1("Lucas", 2), Aluno1("Andre", 3), Aluno1("Jomar", 4))
    val alunoNovo = Aluno1("Jefferson", 4)

    println(alunos.contains(alunoNovo))

    // fazendo a transformação do equals
    val alunos2 = listOf(Aluno2("Thalita", 1), Aluno2("Lucas", 2), Aluno2("Andre", 3), Aluno2("Jomar", 4))
    val alunoNovo2 = Aluno2("Jefferson", 4)

    println(alunos2.contains(alunoNovo2))
}