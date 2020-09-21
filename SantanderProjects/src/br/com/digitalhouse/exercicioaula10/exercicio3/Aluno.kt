package br.com.digitalhouse.exercicioaula10.exercicio3

class Aluno1 (val nome: String, val numeroDeAluno: Int) {

}

class Aluno2 (val nome: String, val numeroDeAluno: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other != numeroDeAluno) return false

        return true
    }
}