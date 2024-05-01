package com.br.gestaovagas.gestaovagas.modules.company.useCases;

import com.br.gestaovagas.gestaovagas.exceptions.UserAlredyExistsException;
import com.br.gestaovagas.gestaovagas.modules.company.entities.CompanyEntity;
import com.br.gestaovagas.gestaovagas.modules.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;
    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail()).ifPresent((user) -> {
            throw new UserAlredyExistsException();
        });

        return this.companyRepository.save(companyEntity);
    }
}
