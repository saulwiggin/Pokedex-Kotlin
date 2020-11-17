package com.example.pokemon.ui.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemon.R
import com.example.pokemon.ui.pokedex.PokemonAdapter
import com.example.pokemon.model.Pokemon
import com.example.pokemon.utils.PokemonColorUtil
import kotlinx.android.synthetic.main.fragment_pokedex.*

import org.koin.androidx.viewmodel.ext.android.viewModel

class PokedexFragment : Fragment() {

    private val pokedexViewModel: PokedexViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ) : View {
        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.window?.statusBarColor =
            PokemonColorUtil(view.context).convertColor(R.color.background)

        val progressBar = progressBar
        val recyclerView = recyclerView
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = layoutManager

        pokedexViewModel.getListPokemon().observe(viewLifecycleOwner, Observer {
            val pokemons: List<Pokemon> = it

            recyclerView.adapter = PokemonAdapter(pokemons, view.context)

            if (pokemons.isNotEmpty())
                progressBar.visibility = View.GONE
        })
    }
}