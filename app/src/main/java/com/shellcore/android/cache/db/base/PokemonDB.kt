package com.shellcore.android.cache.db.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shellcore.android.cache.db.dao.PokemonDao
import com.shellcore.android.cache.db.model.PokemonDBO

@Database(
    entities = [
        PokemonDBO::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PokemonDB: RoomDatabase() {

    companion object {
        const val DB_NAME = "pokemon.db"
    }

    abstract fun pokemonDao(): PokemonDao
}