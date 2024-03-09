package com.br.gestaovagas.gestaovagas.modules.candidate.useCases;

import com.br.gestaovagas.gestaovagas.exceptions.UserAlredyExistsException;
import com.br.gestaovagas.gestaovagas.modules.candidate.entities.CandidateEntity;
import com.br.gestaovagas.gestaovagas.modules.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidate) {
        this.candidateRepository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail()).ifPresent((user) -> {
            throw new UserAlredyExistsException();
        });

        return this.candidateRepository.save(candidate);
    }
}
