package com.shellcore.android.cache.repository.di

import com.shellcore.android.cache.repository.pokemon.PokemonRepository
import com.shellcore.android.cache.repository.pokemon.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PokemonRepositoryModule {

    @Binds
    abstract fun providePokemonRepository(repository: PokemonRepositoryImpl): PokemonRepository
}