package collections.exercicios.exercicio1

fun main() {
    var loteria = Loteria_Sonhos(mapOf(
            0 to "Ovo",
            1 to "Água",
            2 to "Escopeta",
            3 to "Cavalo",
            4 to "Dentista",
            5 to "Fogo"))

    loteria.primeiros_cinco()

    var dicionario = DicionarioApelido()

    dicionario.dicionario()
}