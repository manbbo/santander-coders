package br.com.digitalhouse

import java.time.LocalDate

data class Matricula (val aluno: Aluno,
                      val curso: Curso,
                      var dataMatricula: LocalDate = LocalDate.now()) {
}