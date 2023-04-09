package com.shellcore.android.cache.web.client

import com.shellcore.android.cache.web.services.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PokemonApiModule {

    @Singleton
    @Provides
    fun providePokemonService(): PokemonService {
        return PokemonApiClient.retrofit.create(PokemonService::class.java)
    }
}