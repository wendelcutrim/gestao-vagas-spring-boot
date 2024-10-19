package com.br.gestaovagas.gestaovagas.modules.company.useCases;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.br.gestaovagas.gestaovagas.modules.company.dto.AuthCompanyDto;
import com.br.gestaovagas.gestaovagas.modules.company.entities.CompanyEntity;
import com.br.gestaovagas.gestaovagas.modules.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthCompanyUseCase {
    // A annotation @Value("${}"), captura o valor da variável de ambiente que passamos no application.properties
    @Value("${security.token.secret}")
    private String jwtSecret;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDto authCompanyDto) throws AuthenticationException {
        CompanyEntity company = companyRepository.findByUsername(authCompanyDto.getUsername()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Company not found");
        });

        boolean passwordOk = passwordEncoder.matches(authCompanyDto.getPassword(), company.getPassword());

        if(!passwordOk) {
            throw new AuthenticationException("Company data are incorrect or not exist");
        }

        Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
        return JWT.create().withIssuer("javagas").withSubject(company.getId().toString()).sign(algorithm);
    }
}
