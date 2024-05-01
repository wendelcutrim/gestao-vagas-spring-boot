package com.br.gestaovagas.gestaovagas.modules.company.useCases;

import com.br.gestaovagas.gestaovagas.modules.company.entities.JobEntity;
import com.br.gestaovagas.gestaovagas.modules.company.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {
    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }
}
