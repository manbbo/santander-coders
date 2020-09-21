package collections.exercicios.exercicio4

fun main() {
    val guardaVolumes = GuardaVolumes(mutableMapOf())

    println("Peças guardadas com sucesso! Número: " +
            guardaVolumes.guardarPecas(listOf(Blusa("Adidas", "Runner"),
                    Calca("Polo", "Comfort"))) +
            "\n---------------------------\n")

    guardaVolumes.mostrarPecas()

    guardaVolumes.mostrarPecas(1)

    guardaVolumes.devolverPecas(1)
}