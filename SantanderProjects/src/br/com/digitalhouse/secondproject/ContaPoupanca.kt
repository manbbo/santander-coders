package br.com.digitalhouse.secondproject

class ContaPoupanca(numero: Int, saldo: Float, titular: Cliente) : Conta(numero, saldo, titular) {
    override fun deposito(valor: Float)  {
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

    fun recolherJuros() {
        for (i in 1..12) {
            saldo+=saldo/100
        }
        println("Saldo atual somado ao juros recolhido em 12 meses: $saldo")
    }
}