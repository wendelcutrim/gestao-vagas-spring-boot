package com.br.gestaovagas.gestaovagas.modules.company.controllers;

import com.br.gestaovagas.gestaovagas.modules.company.dto.AuthCompanyDto;
import com.br.gestaovagas.gestaovagas.modules.company.useCases.AuthCompanyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {
    @Autowired
    AuthCompanyUseCase authCompanyUseCase;

    @PostMapping("/company")
    public ResponseEntity<Object> create(@RequestBody AuthCompanyDto authCompanyDto) {
        try {
            String response =  this.authCompanyUseCase.execute(authCompanyDto);
            HashMap<String, String> token = new HashMap<>();
            token.put("token", response);

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Company data invalid or not exists");
        }
    }
}
