package br.com.digitalhouse.pokemons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewParent
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var pokemonList: ArrayList<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pokemonList = getPokemonList()
        var adapter = PokeAdapter(this, pokemonList)
        pagerview.adapter = adapter

        pagerview.setPadding(0, 100, 0, 100)
        pagerview.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                supportActionBar!!.title = pokemonList.get(position).name
            }

            override fun onPageSelected(position: Int) {
                //supportActionBar!!.title = pokemonList.get(position).name
            }

            override fun onPageScrollStateChanged(state: Int) {
                //supportActionBar!!.title = pokemonList.get(state).name
            }

        })
    }

    @JvmName("getPokemonList1")
    fun getPokemonList()  =
    arrayListOf(Pokemon(0,
            "Bulbasaur",
            R.drawable.bulbasaur,
            R.color.planta,
            arrayListOf("Planta", "Venenoso"),
        arrayListOf("Fogo", "Psíquico Gelo")), Pokemon(1,
        "Charmander",
        R.drawable.charmander,
        R.color.fogo,
        arrayListOf("Fogo"),
        arrayListOf("Agua", "Terra", "Rocha")
    ),
    Pokemon(2,
    "Charizard",
    R.drawable.charizard,
    R.color.fogo,
    arrayListOf("Fogo", "Voador"),
    arrayListOf("Água", "Elétrico" , "Rocha")
    ),
        Pokemon(3,
    "Squirtle",
    R.drawable.squirtle,
    R.color.agua,
    arrayListOf("Água"),
    arrayListOf("Grama", "Elétrico")
    ),
        Pokemon(4,
    "Butterfree",
    R.drawable.butterfree,
    R.color.voador,
    arrayListOf("Inseto", "Voador"),
    arrayListOf("Fogo", "Elétrico", "Rocha", "Gelo")
    ),
        Pokemon(5,
    "Pidgey",
    R.drawable.pidgey,
    R.color.voador,
    arrayListOf("Normal", "Voador"),
    arrayListOf("Elétrico", "Rocha", "Gelo")
    )
    )
}
