package br.com.digitalhouse

import java.lang.Exception

class Professor(val RD: RegistroDocente, val nome: String) {

    fun darAula(aula: Aula) {
        println("$nome dando aula de ${aula.materia.nome} inciaindo ${aula.horarioInicio} até ${aula.horarioFim}")
    }

    fun fazerChamada(curso: Curso, alunos: List<Aluno>) {
        if (curso.professor != this) {
            throw Exception("Professor $nome não é responsável pelo curso ${curso.nome}")
        }

        println("Professor $nome fazendo chamada do curso de ${curso.nome}:")

        curso.alunos.forEach {
            if (alunos.contains(it)) {
                println("${it.nome} presente")
            }
            else {
                println("${it.nome} ausente")
            }
        }
    }
}