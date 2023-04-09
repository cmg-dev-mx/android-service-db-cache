package com.shellcore.android.cache.db.dao

import androidx.room.*
import com.shellcore.android.cache.db.model.PokemonDBO

@Dao
interface PokemonDao {

    // Get all pokemon
    @Query("SELECT * FROM pokemon")
    suspend fun getPokemon(): List<PokemonDBO>

    // Insert a list of pokemon
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: List<PokemonDBO>)

    // Delete all pokemon
    @Query("DELETE FROM pokemon")
    suspend fun deleteCache()
}