package collections.exercicios.exercicio1

class DicionarioApelido {
    val nomes = mapOf(
            "João" to listOf("Juan", "Fissura", "Maromba"),
            "Miguel" to listOf("Night Watch", "Bruce Wayne", "Tampinha"),
            "Maria" to listOf("Wonder Woman", "Mary", "Marilene"),
            "Lucas" to listOf("Lukinha", "Jorge", "George")
    )

    fun dicionario(){
        for (nome in nomes){
            println(" ${nome.key} Apelidos = ${nome.value}")
        }
    }

}