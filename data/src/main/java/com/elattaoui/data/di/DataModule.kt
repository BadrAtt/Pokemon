package com.elattaoui.data.di

import com.elattaoui.data.datasource.details.PokemonDetailsDataSource
import com.elattaoui.data.datasource.details.PokemonDetailsDataSourceImpl
import com.elattaoui.data.datasource.pokemons.PokemonsListDataSource
import com.elattaoui.data.datasource.pokemons.PokemonsListDataSourceImpl
import com.elattaoui.data.repository.details.PokemonDetailsRepository
import com.elattaoui.data.repository.details.PokemonDetailsRepositoryImpl
import com.elattaoui.data.repository.pokemons.PokemonsListRepository
import com.elattaoui.data.repository.pokemons.PokemonsListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsPokemonsListDataSource(pokemonsListDataSource: PokemonsListDataSourceImpl)
            : PokemonsListDataSource

    @Binds
    abstract fun bindsPokemonsListRepository(pokemonsListRepository: PokemonsListRepositoryImpl)
            : PokemonsListRepository


    @Binds
    abstract fun bindsPokemonDetailsDataSource(pokemonDetailsDataSource: PokemonDetailsDataSourceImpl)
            : PokemonDetailsDataSource

    @Binds
    abstract fun bindsPokemonDetailsRepository(pokemonDetailsRepository: PokemonDetailsRepositoryImpl)
            : PokemonDetailsRepository
}