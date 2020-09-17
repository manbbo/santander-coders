package collections.exercicios.exercicio4

class Blusa(override val marca: String, override val modelo: String) : Peca() {
    override fun retirada(): String {

        return "Retirada concluida"
    }
}