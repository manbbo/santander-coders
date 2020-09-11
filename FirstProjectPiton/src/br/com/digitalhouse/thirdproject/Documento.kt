package br.com.digitalhouse.thirdproject

class Documento(override val nome: String, override val tipo: String) : Imprimivel {
    override fun imprimir() {
        println("Eu sou um ${tipo.toLowerCase()}")
        println("Nome do arquivo: $nome, e tipo: $tipo")
    }
}