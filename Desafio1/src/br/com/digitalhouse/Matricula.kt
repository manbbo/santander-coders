package br.com.digitalhouse

import java.time.LocalDate

data class Matricula (val aluno: Aluno,
                      val curso: Curso,
                      var dataMatricula: LocalDate = LocalDate.now()) {

    override fun equals(other: Any?): Boolean {
        if (other == aluno.cod || other == curso.cod) return true
        return return false
    }
}