package com.elattaoui.data.repository.pokemons.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.elattaoui.data.datasource.pokemons.PokemonsListDataSource
import com.elattaoui.data.entity.PokemonEntity
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PokemonsListPagingSource @Inject constructor(
    private val pokemonsListDataSource: PokemonsListDataSource
) : PagingSource<Int, PokemonEntity>() {
    override fun getRefreshKey(state: PagingState<Int, PokemonEntity>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonEntity> {
        return try {
            val currentPage = params.key ?: 1
            val pokemons = pokemonsListDataSource.getPokemonsList(currentPage)

            LoadResult.Page(
                data = pokemons.results,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (pokemons.results.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}