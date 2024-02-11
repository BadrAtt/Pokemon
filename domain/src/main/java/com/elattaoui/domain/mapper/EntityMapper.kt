package com.elattaoui.domain.mapper

import com.elattaoui.data.entity.PokemonDetailsEntity
import com.elattaoui.data.entity.PokemonEntity
import com.elattaoui.data.entity.PokemonStatsEntity
import com.elattaoui.data.entity.StatEntity
import com.elattaoui.domain.model.Pokemon
import com.elattaoui.domain.model.PokemonDetails
import com.elattaoui.domain.model.PokemonStats
import com.elattaoui.domain.model.Stat

fun PokemonEntity.toDomainModel() = Pokemon(
    name = name, url = url
)

fun PokemonDetailsEntity.toDomainModel() = PokemonDetails(
    id = id,
    baseExperience = baseExperience,
    height = height,
    name = name,
    order = order,
    weight = weight,
    stats = stats.map { states -> states.toDomainModel() }
)

fun PokemonStatsEntity.toDomainModel() = PokemonStats(
    baseStat = baseStat,
    effort = effort,
    stat = stat.toDomainModel()
)

fun StatEntity.toDomainModel() = Stat(
    name = name,
    url = url
)
