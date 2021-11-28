package com.senac.devweb.api.admin.pokedex.habilidade;

import com.senac.devweb.api.admin.pokedex.pokemon.Pokemon;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

public interface HabilidadeRepresentation {

    @Data
    @Getter
    @Setter
    class CreateOrUpdateHabilidade {

        @NotNull(message = "O pokémon é obrigatório")
        private Long idPokemon;

        @NotNull(message = "O nome é obrigatório")
        @Size(min = 1, max = 100, message = "O nome deve conter entre 1 e 100 caracteres")
        private String nome;

        @Size(min = 1, max = 255, message = "A descrição deve conter entre 1 e 255 caracteres")
        private String descricao;

    }

    @Data
    @Getter
    @Setter
    @Builder
    class Details {
        private Long idPokemon;
        private String nome;
        private String descricao;

        public static Details from(Habilidade habilidade){
            return Details.builder()
                    .idPokemon(habilidade.getId())
                    .nome(habilidade.getNome())
                    .descricao(habilidade.getDescricao())
                    .build();
        }

        public static List<Details> from(List<Habilidade> habilidades) {
            return habilidades.stream().map(Details::from).collect(Collectors.toList());
        }

    }
}
