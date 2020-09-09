package br.com.digitalhouse.secondproject

class Cheque (val valor: Float, val bancoEmissor: String, val dataPagamento: String) {
    fun depositarCheque(c: Conta) {
        c.deposito(valor)
        println("Banco emissor: $bancoEmissor")
        println("Data de Pagamento: $dataPagamento")
    }
}