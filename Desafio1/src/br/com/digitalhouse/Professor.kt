package br.com.digitalhouse

abstract class Professor (val nome: String,
                      val sobrenome: String,
                      val tempoDeCasa: Int,
                      val cod: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == cod) {
            return true
        }
        return false
    }
}