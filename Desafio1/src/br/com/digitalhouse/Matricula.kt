package br.com.digitalhouse

import java.util.*

data class Matricula (val aluno: Aluno,
                      val curso: Curso,
                      val dataMatricula: Date) {
    init {
        //dataMatricula = Date().
    }
}