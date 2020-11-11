package br.com.digitalhouse.pokemons

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.card_pokemon.view.*

class PokeAdapter(private val context: Context, private val pokemonList: ArrayList<Pokemon>) : PagerAdapter() {
    override fun getCount() = pokemonList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(context).inflate(R.layout.card_pokemon, container, false)
        var pokemon = pokemonList.get(position)

        view.img_pokemon.setImageResource(pokemon.image)
        view.tv_name_pokemon.text = pokemon.name.toUpperCase()
        view.tv_type_pokemon.text = "TIPO(S): " + pokemon.types.toString().removePrefix("[").removeSuffix("]")
        view.tv_weakness_pokemon.text = "FRAQUEZAS: " + pokemon.weakness.toString().removePrefix("[").removeSuffix("]")
        view.layout_pokemon.setBackgroundResource(pokemon.color)

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}