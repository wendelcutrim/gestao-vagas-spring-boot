package com.br.gestaovagas.gestaovagas.modules.candidate.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
    private static final int MAX_LENGTH_PASSWORD = 250;
    private static final int MIN_LENGH_PASSWORD = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "The field [username] dosn't be have space characters")
    private String username;

    @Email(message = "The field [email] must be a valid email address")
    private String email;

    @Length(min = MIN_LENGH_PASSWORD, max = MAX_LENGTH_PASSWORD, message = "The field [password] must be between " + MIN_LENGH_PASSWORD + " and " + MAX_LENGTH_PASSWORD +  " characters")
    private String password;

    private String description;

    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
