package br.com.digitalhouse.desafio7_2.models

data class Gastos(val id: Int, val desc: String, val valor: Double) {
    override fun toString(): String {
        return "Gasto($id, $desc, $valor)"
    }
}

