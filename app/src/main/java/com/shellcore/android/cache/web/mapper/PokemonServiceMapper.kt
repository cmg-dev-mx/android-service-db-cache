package com.shellcore.android.cache.web.mapper

import com.shellcore.android.cache.core.model.PokemonBO
import com.shellcore.android.cache.web.model.Result
import java.util.*

object PokemonServiceMapper: Function1<List<Result>, List<PokemonBO>> {

    override fun invoke(p1: List<Result>): List<PokemonBO> {
        val list = arrayListOf<PokemonBO>()
        p1.forEach {
            list.add(mapPokemonBO(it))
        }
        return list
    }

    private fun mapPokemonBO(pokemonSO: Result): PokemonBO {
        val number = getPokemonNumber(pokemonSO)
        return PokemonBO(
            number = number,
            name = pokemonSO.name.toTitleCase(),
            imageUrl = parsePokemonImageUrl(number)
        )
    }

    private fun parsePokemonImageUrl(number: Int) =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"

    private fun getPokemonNumber(pokemonSO: Result) =
        pokemonSO.url.substringAfter("pokemon/").substringBefore("/").toInt()

    private fun String.toTitleCase() = this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}
