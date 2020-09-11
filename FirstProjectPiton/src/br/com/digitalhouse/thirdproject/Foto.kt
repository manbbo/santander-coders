package br.com.digitalhouse.thirdproject

class Foto(override val nome: String, override val tipo: String) : Imprimivel {
    override fun imprimir() {
        println("Eu sou uma ${tipo.toLowerCase()}")
        println("Nome do arquivo: $nome, e tipo: $tipo")
    }
}