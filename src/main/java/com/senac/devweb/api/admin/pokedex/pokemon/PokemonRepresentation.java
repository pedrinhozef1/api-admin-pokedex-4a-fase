package com.senac.devweb.api.admin.pokedex.pokemon;

import com.senac.devweb.api.admin.pokedex.habilidade.Habilidade;
import com.senac.devweb.api.admin.pokedex.utils.TipoPokemon;
import com.senac.devweb.api.admin.pokedex.vantagem.Vantagem;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface PokemonRepresentation {

    @Data
    @Getter
    @Setter
    class CreateOrUpdatePokemon {
        @NotNull(message = "O nome é obrigatório")
        @Size(min = 1, max = 100, message = "O nome deve conter entre 1 e 100 caracteres")
        private String nome;

        @NotNull(message = "O porte é obrigatório")
        private Pokemon.Porte porte;

        @NotNull(message = "O tipo é obrigatório")
        @Enumerated(EnumType.STRING)
        private TipoPokemon tipoPokemon;

        @NotNull(message = "A vantagem é obrigatória")
        private List<Vantagem> vantagens  = new ArrayList<>();

        @NotNull(message = "A habilidade é obrigatória")
        private List<Habilidade> habilidades = new ArrayList<>();
    }

    @Data
    @Getter
    @Setter
    @Builder
    class Details {
        private Long id;
        private String nome;
        private Pokemon.Porte porte;
        private TipoPokemon tipo;
        private List<Vantagem> vantagens;
        private List<Habilidade> habilidades;

        public static Details from(Pokemon pokemon) {
            return Details.builder()
                    .id(pokemon.getId())
                    .nome(pokemon.getNome())
                    .porte(pokemon.getPorte())
                    .tipo(pokemon.getTipoPokemon())
                    .vantagens(pokemon.getVantagens())
                    .habilidades(pokemon.getHabilidades())
                    .build();
        }

        public static List<Details> from(List<Pokemon> pokemons) {
            return pokemons.stream().map(Details::from).collect(Collectors.toList());
        }
    }
}
