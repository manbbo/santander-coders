package br.com.digitalhouse

import java.time.LocalTime

class Aula(val materia: Materia, horarioInicio: LocalTime, horarioFim: LocalTime) {

    var horarioInicio: LocalTime = horarioInicio
        set(value) {
            field = value
            verificaHorarios()
        }
    var horarioFim: LocalTime = horarioFim
        set(value) {
            field = value
            verificaHorarios()
        }

    init {
        verificaHorarios()
    }

    private fun verificaHorarios() {
        if (horarioInicio >= horarioFim) {
            throw Exception("O horário inicial deve ser anterior ao final!")
        }
    }
}