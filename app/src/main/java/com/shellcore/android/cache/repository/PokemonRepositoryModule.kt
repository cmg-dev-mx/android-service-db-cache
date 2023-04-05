package com.shellcore.android.cache.repository

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