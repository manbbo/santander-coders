package collections.exercicios.exercicio4

class Calca(override val marca: String, override val modelo: String) : Peca() {
    public override fun retirada(): String {
        return "Retirada concluida"
    }
}