package br.com.digitalhouse.secondproject

class ContaCorrente(numero: Int, saldo: Float, titular: Cliente) : Conta(numero, saldo, titular) {
    override fun deposito(valor: Float) {
        saldo += valor
        println("Saldo após o depósito: $saldo")
    }

    override fun saque(valor: Float) {
        if (valor > saldo) {
            return
        }

        saldo-=valor
        println("Saldo após o saque: $saldo")
    }
}