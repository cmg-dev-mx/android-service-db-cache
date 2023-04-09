package com.shellcore.android.cache.ui.main.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shellcore.android.cache.core.model.PokemonBO
import com.shellcore.android.cache.repository.pokemon.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    private val _queryResponse = MutableLiveData<Result<List<PokemonBO>>>()
    val queryResponse: LiveData<Result<List<PokemonBO>>> = _queryResponse

    fun queryData() {
        viewModelScope.launch {
            repository.queryPokemonList().collect {
                _queryResponse.value = it
            }
        }
    }

    fun clearData() {
        viewModelScope.launch {
            repository.clearPokemonList().collect {
                _queryResponse.value = it
            }
        }
    }
}
