package com.br.gestaovagas.gestaovagas.modules.candidate.repository;

import com.br.gestaovagas.gestaovagas.modules.candidate.entities.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
}
