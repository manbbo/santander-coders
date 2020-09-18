package br.com.digitalhouse.exercicioaula10.exercicio4

data class Aluno2 (val nome: String, val numeroDeAluno: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other != numeroDeAluno) return false

        return true
    }
}