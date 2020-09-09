package br.com.digitalhouse.secondproject

abstract class Conta (val numero: Int, var saldo: Float, var titular: Cliente) {
    init {
        println("Informações da conta:" +
                "\n-----------------------------\n"+
                "Numero: $numero"+
        "\nTitular: ${titular.nome} ${titular.sobrenome}"+
        "\n-----------------------------\n")
    }

    abstract fun deposito(valor: Float)

    abstract fun saque(valor: Float)
}