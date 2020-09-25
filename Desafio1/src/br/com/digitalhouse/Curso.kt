package br.com.digitalhouse

data class Curso (val nome: String,
                  val cod: Int,
                  var titular: ProfessorTitular,
                  var adjunto: ProfessorAdjunto,
                  val qtMaxAlunos: Int,
                  val listaDeAlunos: MutableList<Aluno>) {
    override fun equals(other: Any?): Boolean {
        if (other == cod) {
            return true
        }
        return false
    }
}