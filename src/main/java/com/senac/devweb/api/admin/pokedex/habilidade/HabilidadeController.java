package com.senac.devweb.api.admin.pokedex.habilidade;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/habilidade")
@AllArgsConstructor
@CrossOrigin("*")
public class HabilidadeController {

    private HabilidadeService habilidadeService;
    private HabilidadeRepository habilidadeRepository;

    @PostMapping("/")
    public ResponseEntity<HabilidadeRepresentation.Details> createHabilidade(
            @Valid @RequestBody HabilidadeRepresentation.CreateOrUpdateHabilidade createOrUpdateHabilidade
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(HabilidadeRepresentation.Details.from(this.habilidadeService.save(createOrUpdateHabilidade)));
    }
}
