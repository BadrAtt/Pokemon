package com.elattaoui.domain.mapper

import com.elattaoui.data.entity.PokemonEntity
import com.elattaoui.domain.model.Pokemon

fun PokemonEntity.toDomainModel() = Pokemon(
    name = name, url = url
)