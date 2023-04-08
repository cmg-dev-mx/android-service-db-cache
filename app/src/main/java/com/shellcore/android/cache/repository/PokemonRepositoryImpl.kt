package com.shellcore.android.cache.repository

import com.shellcore.android.cache.core.model.PokemonBO
import com.shellcore.android.cache.repository.mapper.PokemonListMapper
import com.shellcore.android.cache.web.services.PokemonService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val service: PokemonService
) : PokemonRepository {

    override suspend fun queryPokemonList(): Flow<Result<List<PokemonBO>>> {
        return try {
            flow {
                val response = service.getPokemonList(20, 0)
                val responseMapped = PokemonListMapper.invoke(response.results)
                emit(Result.success(responseMapped))
            }
        } catch (e: Exception) {
            flow {
                emit(Result.failure(e))
            }
        }
    }
}