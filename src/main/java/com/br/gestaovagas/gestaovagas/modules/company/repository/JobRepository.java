package com.br.gestaovagas.gestaovagas.modules.company.repository;

import com.br.gestaovagas.gestaovagas.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
