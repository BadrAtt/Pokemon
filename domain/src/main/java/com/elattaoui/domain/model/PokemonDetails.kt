package com.elattaoui.domain.model

data class PokemonDetails(
    val id: Int,
    val baseExperience: Int,
    private val height: Int,
    val name: String,
    val order: Int,
    private val weight: Int,
    val stats: List<PokemonStats>
) {
    val imageUrl: String
        get() {
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                    "pokemon/other/official-artwork/$id.png"
        }
    val weightKg: Double
        get() = weight.toDouble() / 10
    val heightM: Double
        get() = height.toDouble() / 10
}