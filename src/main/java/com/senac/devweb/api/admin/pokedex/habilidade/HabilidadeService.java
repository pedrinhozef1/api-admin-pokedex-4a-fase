package com.senac.devweb.api.admin.pokedex.habilidade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HabilidadeService {

    private HabilidadeRepository habilidadeRepository;

    public Habilidade save(HabilidadeRepresentation.CreateOrUpdateHabilidade createOrUpdateHabilidade) {
        return this.habilidadeRepository.save(Habilidade.builder()
                .id(createOrUpdateHabilidade.getIdPokemon())
                .nome(createOrUpdateHabilidade.getNome())
                .descricao(createOrUpdateHabilidade.getDescricao())
                .build());
    }

}
