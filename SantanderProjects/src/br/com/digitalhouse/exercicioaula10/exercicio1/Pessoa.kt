package br.com.digitalhouse.exercicioaula10.exercicio1

//------------------------------EX1-----------------------------------

// 1    Criar a classe Pessoa que tenha como propriedades nome (String) e RG(Integer)
// 2    Na classe Main criar duas pessoas com o mesmo numero de RG
// 3    Usando equals, comparar se a primeira pessoa criada é igual à segunda.
//          Qual é o resultado?
// 4    Sobrescrever o equals da classe Pessoa para que compare apenas o número de RG.


data class Pessoa(var nome: String, var RG: Int) {
    override fun equals(other: Any?): Boolean {
        return this.RG == other
    }
}
