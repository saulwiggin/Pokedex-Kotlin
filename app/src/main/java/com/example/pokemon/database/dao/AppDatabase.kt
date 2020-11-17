package com.example.pokemon.database.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokemon.database.dao.PokemonDAO
import com.example.pokemon.model.Pokemon

@Database(entities = [Pokemon::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDAO(): PokemonDAO
}
