package br.com.digitalhouse.thirdproject

class Contrato(override val nome: String, override val tipo: String) : Imprimivel {
    override fun imprimir() {
        println("Sou um contrato muito legal")
        println("Nome do arquivo: $nome, e tipo: $tipo")
    }
}