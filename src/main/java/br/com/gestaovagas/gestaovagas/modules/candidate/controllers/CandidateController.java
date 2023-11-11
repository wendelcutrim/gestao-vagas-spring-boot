package br.com.gestaovagas.gestaovagas.modules.candidate.controllers;

import br.com.gestaovagas.gestaovagas.modules.candidate.entities.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("")
    public void create(@Valid @RequestBody CandidateEntity candidate) {
        System.out.println("Candidato: " + candidate.getEmail());
        System.out.println("Candidato dados: " + candidate.toString());
    }
}
