package br.com.digitalhouse.pokemons

data class Pokemon (val ID: Int,
                    var name: String,
                    var image: Int,
                    var color: Int,
                    var types: ArrayList<String>,
                    var weakness: ArrayList<String>) {

}