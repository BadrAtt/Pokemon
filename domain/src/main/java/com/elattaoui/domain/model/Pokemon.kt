package com.elattaoui.domain.model

data class Pokemon(
    val name: String,
    val url: String,
) {
    val imageUrl: String
        get() {
            val id = url.split("/".toRegex()).dropLast(1).last()
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                    "pokemon/other/official-artwork/$id.png"
        }
}
