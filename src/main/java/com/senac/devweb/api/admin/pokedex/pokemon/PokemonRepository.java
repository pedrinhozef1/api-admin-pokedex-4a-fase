package com.senac.devweb.api.admin.pokedex.pokemon;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Long>,
        QuerydslPredicateExecutor<Pokemon> {
}
