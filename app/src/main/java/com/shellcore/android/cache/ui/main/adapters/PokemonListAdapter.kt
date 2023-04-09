package com.shellcore.android.cache.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shellcore.android.cache.core.model.PokemonBO
import com.shellcore.android.cache.databinding.ItemPokemonBinding
import com.shellcore.android.cache.utils.setImageFromUrl

class PokemonListAdapter(
    private val pokemonList: ArrayList<PokemonBO> = arrayListOf(),
    private val onClickElement: (PokemonBO) -> Unit
): RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemPokemonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pokemonList[position], onClickElement)
    }

    override fun getItemCount() = pokemonList.size

    fun updateList(pokemonList: List<PokemonBO>) {
        this.pokemonList.clear()
        this.pokemonList.addAll(pokemonList)
        notifyDataSetChanged()
    }

    class ViewHolder(binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root) {

        private val pokemonImg = binding.itemPokemonImage
        private val pokemonNumber = binding.itemPokemonNumberTxt
        private val pokemonName = binding.itemPokemonNameTxt

        fun bind(pokemon: PokemonBO, onClickElement: (PokemonBO) -> Unit) {
            pokemonImg.setImageFromUrl(pokemon.imageUrl)
            pokemonNumber.text = pokemon.number.toString()
            pokemonName.text = pokemon.name
            itemView.setOnClickListener {
                onClickElement(pokemon)
            }
        }
    }
}