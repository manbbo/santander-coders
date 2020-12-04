package br.com.digitalhouse

data class Aluno(val nome: String,
                 val sobrenome: String,
                 val cod: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == cod) {
            return true
        }
        return false
    }
}