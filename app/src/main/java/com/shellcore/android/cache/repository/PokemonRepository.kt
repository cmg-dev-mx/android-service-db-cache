package com.shellcore.android.cache.repository

import com.shellcore.android.cache.core.model.PokemonBO
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun queryPokemonList(): Flow<Result<List<PokemonBO>>>
}
