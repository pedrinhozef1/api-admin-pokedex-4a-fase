package com.senac.devweb.api.admin.pokedex.habilidade;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HabilidadeRepository extends PagingAndSortingRepository<Habilidade, Long>,
        QuerydslPredicateExecutor<Habilidade> {
}
