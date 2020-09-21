package br.com.digitalhouse

class Aluno(val registroAcademico: RegistroAcademico, val nome: String, val sobrenome: String) {

    fun assistirAula(aula: Aula) {
        println("Eu, $nome, estou assistindo a aula de ${aula.materia.nome}")
    }

    fun fazerDeverDeCasa(materia: Materia) {
        println("Eu, $nome, estou fazendo o dever da matéria de ${materia.nome}")
    }
}