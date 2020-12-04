package br.com.digitalhouse

import java.time.LocalTime

fun main() {
    val aluno1 = Aluno(RegistroAcademico(123123), "João", "Silva")
    val aluno2 = Aluno(RegistroAcademico(123124), "Fulano", "de Tal")
    val aluno3 = Aluno(RegistroAcademico(123125), "Sicrano", "Oliveira")
    val aluno4 = Aluno(RegistroAcademico(12323), "Joao", "Santos")

    val alunos = listOf(aluno1, aluno2, aluno3, aluno4)

    val professor = Professor(RegistroDocente(321321), "Roberto")

    val materia = Materia("Estruturas de Dados")
    val aula = Aula(materia, LocalTime.of(9, 50), LocalTime.of(10, 40))

    val curso = Curso("Engenharia de Computação", listOf(aula), professor, alunos)

    aluno1.assistirAula(aula)
    aluno2.fazerDeverDeCasa(materia)

    professor.fazerChamada(curso, listOf(aluno1, aluno2))
    professor.darAula(aula)

    println("acabou o sistema")
}
