package com.br.gestaovagas.gestaovagas.modules.company.entities;

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
@Entity(name="company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "The field [name] is required")
    private String name;

    @NotBlank(message = "The field [username] is required")
    @Pattern(regexp = "\\S+", message = "The field [username] dosn't be blank")
    private String username;

    @NotBlank(message = "The field [email] is required")
    @Email(message="The field [email] must be a valid email address")
    private String email;

    @NotBlank(message = "The field [password] is required")
    @Length(min = 6, max = 100, message = "The field [password] must be at least 6 characters long and at least 100 characters")
    private String password;

    @NotBlank(message = "The field [website] is required")
    @Length(min = 9, max = 255, message = "The field [website] must be at least 9 characters long and at least 255 characters")
    private String website;

    private String description;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
