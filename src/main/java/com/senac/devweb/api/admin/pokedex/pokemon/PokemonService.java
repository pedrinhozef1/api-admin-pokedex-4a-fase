package com.senac.devweb.api.admin.pokedex.pokemon;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;

}
