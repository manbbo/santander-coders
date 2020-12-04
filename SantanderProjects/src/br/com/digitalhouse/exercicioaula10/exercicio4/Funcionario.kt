package br.com.digitalhouse.exercicioaula10.exercicio4

//------------------------------EX4-----------------------------------
data class Funcionario(val nome: String, val numeroDeRegistro: Int) {
    override fun equals(other: Any?): Boolean {
        if (other != null && other is Funcionario) {
            if (this.numeroDeRegistro == other.numeroDeRegistro) {
                return true
            }
        }

        return false
    }
}