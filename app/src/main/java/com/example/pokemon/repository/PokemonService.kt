package com.example.pokemon.repository

import com.example.pokemon.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {
    @GET("pokemon.json")
    fun get(): Call<List<Pokemon>>
}