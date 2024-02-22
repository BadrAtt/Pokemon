package com.elattaoui.data.mapper

import com.elattaoui.data.entity.PokemonStatsEntity
import com.elattaoui.data.entity.StatEntity
import com.elattaoui.domain.model.PokemonStats
import com.elattaoui.domain.model.Stat

object PokemonStatsEntityMapper : Mapper<PokemonStatsEntity, PokemonStats> {
    override fun map(data: PokemonStatsEntity): PokemonStats {
        return PokemonStats(
            baseStat = data.baseStat,
            effort = data.effort,
            stat = StatEntityMapper.map(data.stat)
        )
    }
}

object StatEntityMapper : Mapper<StatEntity, Stat> {
    override fun map(data: StatEntity): Stat {
        return Stat(
            name = data.name,
            url = data.url
        )
    }
}