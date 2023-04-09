package com.shellcore.android.cache.db.di

import android.content.Context
import androidx.room.Room
import com.shellcore.android.cache.db.base.PokemonDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun providePokemonDB(@ApplicationContext context: Context): PokemonDB = Room.databaseBuilder(
        context,
        PokemonDB::class.java,
        PokemonDB.DB_NAME
    ).build()

    @Singleton
    @Provides
    fun providePokemonDao(db: PokemonDB) = db.pokemonDao()
}