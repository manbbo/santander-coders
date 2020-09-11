package br.com.digitalhouse.secondproject

class Cheque (var c: Conta) {
    fun depositarCheque(valor: Float, bancoEmissor: String, dataPagamento: String) {
        c.deposito(valor)
        println("Banco emissor: $bancoEmissor")
        println("Data de Pagamento: $dataPagamento")
    }
}