package collections.exercicios.exercicio4

class Calca(override val marca: String, override val modelo: String) : Peca() {
    override fun retirada(): String {
        return "Retirada concluida"
    }
}