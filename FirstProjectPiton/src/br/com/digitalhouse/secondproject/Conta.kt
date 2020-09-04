package br.com.digitalhouse.secondproject

class Conta (val numero: Int, var saldo: Float, var titular: Cliente) {
    init {
        println("Informações da conta:" +
                "\n-----------------------------\n"+
                "Numero: $numero"+
        "\nTitular: ${titular.nome} ${titular.sobrenome}"+
        "\n-----------------------------\n")
    }

    fun deposito(valor: Float) {
        saldo += valor
        println("Saldo após o depósito: $saldo")
    }

    fun saque(valor: Float) {
        if ((saldo - valor <= 0)) {
            println("Saldo insuficiente para o saque")
            return
        }

        saldo -= valor
        println("Saldo após o saque: $saldo")
    }
}