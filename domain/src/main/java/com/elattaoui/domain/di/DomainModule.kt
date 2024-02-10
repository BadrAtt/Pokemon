package com.elattaoui.domain.di

import com.elattaoui.domain.usecase.pokemons.GetPokemonsList
import com.elattaoui.domain.usecase.pokemons.GetPokemonsListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class DomainModule {


    @Binds
    @ActivityScoped
    abstract fun bindsGetPokemonsListUseCase(pokemonsListUseCase: GetPokemonsList): GetPokemonsListUseCase
}