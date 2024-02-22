package com.elattaoui.data.mapper

import com.elattaoui.data.entity.PokemonEntity
import com.elattaoui.domain.model.Pokemon

object PokemonEntityMapper : Mapper<PokemonEntity, Pokemon> {
    override fun map(data: PokemonEntity): Pokemon = Pokemon(
        name = data.name,
        url = data.url
    )
}