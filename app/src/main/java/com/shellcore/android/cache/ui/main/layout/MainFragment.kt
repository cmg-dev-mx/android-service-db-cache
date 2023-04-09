package com.shellcore.android.cache.ui.main.layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.shellcore.android.cache.databinding.FragmentMainBinding
import com.shellcore.android.cache.ui.main.adapters.PokemonListAdapter
import com.shellcore.android.cache.ui.main.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val pokemonListAdapter = PokemonListAdapter {pokemon ->
        Snackbar.make(binding.root, "Pokemon: ${pokemon.name}", Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.mainPokemonListRec.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = pokemonListAdapter
            setHasFixedSize(true)
        }

        binding.mainQueryBtn.setOnClickListener {
            viewModel.queryData()
        }

        binding.mainClearBtn.setOnClickListener {
            viewModel.clearData()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.queryResponse.observe(viewLifecycleOwner) { result ->
            result.onSuccess {
                pokemonListAdapter.updateList(it)
            }.onFailure {
                Snackbar.make(binding.root, "Failure: ${it.message}", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}