package com.br.gestaovagas.gestaovagas.modules.company.controllers;

import com.br.gestaovagas.gestaovagas.modules.company.entities.JobEntity;
import com.br.gestaovagas.gestaovagas.modules.company.useCases.CreateJobUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    CreateJobUseCase createJobUseCase;
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody JobEntity jobEntity) {
            try {
                JobEntity result = this.createJobUseCase.execute(jobEntity);
                return ResponseEntity.ok().body(result);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().body(e.getMessage());
            }

    }
}
