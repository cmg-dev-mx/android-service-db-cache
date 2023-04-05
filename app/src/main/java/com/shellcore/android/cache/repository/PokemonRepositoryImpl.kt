package com.shellcore.android.cache.repository

import com.shellcore.android.cache.core.model.PokemonBO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor() : PokemonRepository {

    override suspend fun queryPokemonList(): Flow<Result<List<PokemonBO>>> {
        delay(2000)
        return flow {
            emit(Result.success(listOf(PokemonBO(1, "Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"))))
        }
    }
}