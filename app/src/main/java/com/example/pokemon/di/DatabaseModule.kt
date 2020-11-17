package com.example.pokemon.di

import androidx.room.Room
import com.example.pokemon.R
import com.example.pokemon.database.dao.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "pokedex"
        ).build()
    }

    single {
        get<AppDatabase>().pokemonDAO()
    }
}

