package collections.exercicios.exercicio4

class GuardaVolumes(val dicionario: MutableMap<Int, List<Peca>>,
                    var counter: Int? = dicionario.size) { //porque começa no zero

    fun guardarPecas(pecas: List<Peca>) : Int {
        dicionario[counter!!] = pecas
        counter = dicionario.size
        return counter as Int
    }

    fun mostrarPecas() {
        for (i in dicionario)
        {
            println("Volume num ${i.key.plus(1)}, peças:")
            for (j in i.value)
                println("- Marca: ${j.marca}\n" +
                        "- Modelo: ${j.modelo}\n")
        }
    }

    fun mostrarPecas(numero: Int) {
        println("Peças no volume $numero:")
        for (i in dicionario[numero.minus(1)]!!)
        println("- Marca: ${i.marca}\n" +
                "- Modelo: ${i.modelo}\n")
    }

    fun devolverPecas(numero: Int) {
        println("Devolvendo as peças do volume $numero:")

        for (i in dicionario[numero.minus(1)]!!)
            println("- Marca: ${i.marca}\n" +
                    "- Modelo: ${i.modelo}\n" +
                    "${i.retirada()}")

        dicionario.remove(numero.minus(1))
        println("\nDevolução concluída!\n")
    }
}