package com.elattaoui.data.mapper

import com.elattaoui.data.entity.PokemonDetailsEntity
import com.elattaoui.domain.model.PokemonDetails

object PokemonDetailsMapper : Mapper<PokemonDetailsEntity, PokemonDetails> {
    override fun map(data: PokemonDetailsEntity): PokemonDetails = PokemonDetails(
        id = data.id,
        baseExperience = data.baseExperience,
        height = data.height,
        name = data.name,
        order = data.order,
        weight = data.weight,
        stats = data.stats.map { pokemonStats -> PokemonStatsEntityMapper.map(pokemonStats) }
    )
}