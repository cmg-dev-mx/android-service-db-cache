package com.shellcore.android.cache.repository.pokemon

import com.shellcore.android.cache.core.model.PokemonBO
import com.shellcore.android.cache.db.dao.PokemonDao
import com.shellcore.android.cache.db.mapper.PokemonDBMapper
import com.shellcore.android.cache.web.mapper.PokemonServiceMapper
import com.shellcore.android.cache.web.services.PokemonService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val dao: PokemonDao,
    private val service: PokemonService
) : PokemonRepository {

    override suspend fun queryPokemonList(): Flow<Result<List<PokemonBO>>> {
        return try {
            flow {
                val dbResult = dao.getPokemon()
                if (dbResult.isNotEmpty()) {
                    emit(Result.success(PokemonDBMapper.fromDboToBo(dbResult)))
                }

                val response = service.getPokemonList(20, 0)
                val responseMapped = PokemonServiceMapper.invoke(response.results)
                dao.insertPokemon(PokemonDBMapper.fromBoToDbo(responseMapped))
                emit(Result.success(responseMapped))
            }
        } catch (e: Exception) {
            flow {
                emit(Result.failure(e))
            }
        }
    }
}