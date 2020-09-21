package br.com.digitalhouse.exercicioaula10.exercicio2

data class Coca(val tamanho: Int, val preco: Double) {
    // Aqui seria comparado cada variavel mas como implementamos a função equals
    // comparamos somente a varaivel tamanho em relação a outra classe Coca.
    override fun equals(other: Any?): Boolean {
        if (other != null && other is Coca) {
            if (this.tamanho == other.tamanho) {
                return true
            }
        }

        return false
    }
}