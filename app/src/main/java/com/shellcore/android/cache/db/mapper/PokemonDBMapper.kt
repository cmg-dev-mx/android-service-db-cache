package com.shellcore.android.cache.db.mapper

import com.shellcore.android.cache.core.model.PokemonBO
import com.shellcore.android.cache.db.model.PokemonDBO

object PokemonDBMapper {

    fun fromDboToBo(p1: List<PokemonDBO>): List<PokemonBO> {
        val list = arrayListOf<PokemonBO>()
        p1.forEach { dbo ->
            list.add(PokemonBO(dbo.id, dbo.name, dbo.imageUrl))
        }
        return list
    }

    fun fromBoToDbo(p1: List<PokemonBO>): List<PokemonDBO> {
        val list = arrayListOf<PokemonDBO>()
        p1.forEach { bo ->
            list.add(PokemonDBO(bo.number, bo.name, bo.imageUrl))
        }
        return list
    }
}
