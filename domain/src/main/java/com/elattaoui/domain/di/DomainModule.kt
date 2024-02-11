package com.elattaoui.domain.di

import com.elattaoui.domain.usecase.detail.GetPokemonDetails
import com.elattaoui.domain.usecase.detail.GetPokemonDetailsUseCase
import com.elattaoui.domain.usecase.pokemons.GetPokemonsList
import com.elattaoui.domain.usecase.pokemons.GetPokemonsListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class DomainModule {


    @Binds
    @ViewModelScoped
    abstract fun bindsGetPokemonsListUseCase(pokemonsListUseCase: GetPokemonsList): GetPokemonsListUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsGetPokemonDetailsUseCase(pokemonDetailsUseCase: GetPokemonDetails): GetPokemonDetailsUseCase
}