package br.com.digitalhouse.thirdproject

class Impressora {
    val listaImprimivel = mutableListOf<Imprimivel>()

    fun addImprimivel(item: Imprimivel) {
        listaImprimivel.add(item)
    }

    fun printAll() {
        for (i in listaImprimivel) {
            i.imprimir()
        }
    }
}