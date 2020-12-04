package br.com.digitalhouse

data class Curso (val nome: String,
                  val cod: Int,
                  val qtMaxAlunos: Int,
                  var titular: ProfessorTitular? = null,
                  var adjunto: ProfessorAdjunto? = null,
                  val listaDeAlunos: MutableList<Aluno>? = mutableListOf<Aluno>()) {

    override fun equals(other: Any?): Boolean {
        if (other == cod) {
            return true
        }
        return false
    }

    fun addAluno(aluno: Aluno) : Boolean {
        if (listaDeAlunos!!.size < qtMaxAlunos) {
            this.listaDeAlunos!!.add(aluno)
            println ("Aluno cadastrado no curso com sucesso")
            return true
        } else {
            println("Curso cheio")
            return false
        }
    }

    fun addProf(profTitular: ProfessorTitular) {
        titular = profTitular
    }

    fun addProf(profAdjunto: ProfessorAdjunto) {
        adjunto = profAdjunto
    }

    fun removeAluno(aluno: Aluno) {
        this.listaDeAlunos!!.remove(aluno)
    }
}