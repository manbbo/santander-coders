package br.com.digitalhouse.secondproject

fun main() {
    val cliente = Cliente("Andre", "Saba")
    val cliente2 = Cliente("Rodolfo", "Ruiz")
    val conta = Conta(1, 10000f, cliente)
    val conta2 = Conta(2, 1000000f, cliente2)

    println("Saldo da conta: ${conta.saldo}")
    println("Saldo da conta: ${conta2.saldo}")
    conta.deposito(10000f)
    conta2.saque(2f)
}