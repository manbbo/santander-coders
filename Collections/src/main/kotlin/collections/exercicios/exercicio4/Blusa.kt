package collections.exercicios.exercicio4

class Blusa(override val marca: String, override val modelo: String) : Peca() {
    public override fun retirada(): String {

        return "Retirada concluida"
    }
}