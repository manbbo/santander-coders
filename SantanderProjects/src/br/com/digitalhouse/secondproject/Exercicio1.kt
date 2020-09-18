package br.com.digitalhouse.secondproject

fun main() {
    val cliente = Cliente("Andre", "Saba")
    val cliente2 = Cliente("Rodolfo", "Ruiz")
    val contaCorrente = ContaCorrente(1, 10000f, cliente)
    val contaPoupanca = ContaCorrente(2, 10000f, cliente2)
    cliente.cheque = Cheque(contaPoupanca)

    println("Saldo da conta Corrente de Andre: ${contaCorrente.saldo}")
    println("Saldo da conta Poupança de Rodolfo: ${contaPoupanca.saldo}")
    print("Conta Andre: ")
    contaCorrente.deposito(10000f)
    print("Conta Rodolfo: ")
    contaPoupanca.saque(2000f)
    println("\nDeposito de cheque de Andre: ")
    cliente.cheque!!.depositarCheque(200f, "Santander", "12/09/2020")
}