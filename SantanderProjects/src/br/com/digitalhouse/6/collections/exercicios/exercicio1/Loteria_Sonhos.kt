package collections.exercicios.exercicio1

class Loteria_Sonhos(val loteria : Map<Int, String>) {
    fun primeiros_cinco() {
        for (i in 0..6) println(loteria[i])
    }
}