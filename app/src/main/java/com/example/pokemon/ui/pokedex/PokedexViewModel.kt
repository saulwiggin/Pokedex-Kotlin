package com.example.pokemon.ui.pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pokemon.database.dao.PokemonDAO
import com.example.pokemon.model.Pokemon
import com.example.pokemon.repository.PokemonService
import kotlin.concurrent.thread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokedexViewModel(private val pokemonDAO: PokemonDAO, private val pokemonService: PokemonService) : ViewModel() {

    init {
        initNetworkRequest()
    }

    private fun initNetworkRequest() {
        // call pokemon service
        val call = pokemonService.get()

        // put the list of pokemons in the database
        call.enqueue(object : Callback<List<Pokemon>?> {
            override fun onResponse(
                call: Call<List<Pokemon>?>?,
                response: Response<List<Pokemon>?>?
            ) {
                response?.body()?.let { pokemon: List<Pokemon> ->
                    thread {
                        // pokemonDAO.add(pokemons)
                    }
                }
            }

            override fun onFailure(call: Call<List<Pokemon>?>?, t: Throwable?) {
                // TODO handle failure
            }
        })
    }

            fun getListPokemon(): LiveData<List<Pokemon>> {
                return pokemonDAO.all()
            }
}