package com.br.gestaovagas.gestaovagas.modules.candidate.controllers;

import com.br.gestaovagas.gestaovagas.exceptions.GenericErrorResponseDTO;
import com.br.gestaovagas.gestaovagas.modules.candidate.entities.CandidateEntity;
import com.br.gestaovagas.gestaovagas.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidate) {
        try {
            var result = this.createCandidateUseCase.execute(candidate);
            return ResponseEntity.ok(result);
        } catch (Exception err) {
            GenericErrorResponseDTO response = new GenericErrorResponseDTO();
//            String statusCode = Integer.toString(HttpStatus.BAD_REQUEST.value());

            response.setMessage(err.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());

            return ResponseEntity.badRequest().body(response);
        }
    }
}
