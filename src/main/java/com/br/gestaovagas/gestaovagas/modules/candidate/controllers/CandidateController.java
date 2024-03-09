package com.br.gestaovagas.gestaovagas.modules.candidate.controllers;

import com.br.gestaovagas.gestaovagas.modules.candidate.entities.CandidateEntity;
import com.br.gestaovagas.gestaovagas.modules.candidate.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidate) {
        return this.candidateRepository.save(candidate);
    }
}
