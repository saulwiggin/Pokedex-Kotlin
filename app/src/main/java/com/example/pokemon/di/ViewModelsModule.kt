package com.example.pokemon.di

import com.example.pokemon.ui.pokedex.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { PokedexViewModel(get(), get())}
}