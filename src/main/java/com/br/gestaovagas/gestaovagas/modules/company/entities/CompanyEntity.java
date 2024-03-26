package com.br.gestaovagas.gestaovagas.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity(name="company")
public class CompanyEntity {
    private static final int MIN_LENGTH_NAME = 3;
    private static final int MAX_LENGTH_NAME = 250;
    private static final int MIN_LENGTH_EMAIL = 3;
    private static final int MAX_LENGTH_EMAIL = 200;
    private static final int MAX_LENGTH_PASSWORD = 250;
    private static final int MIN_LENGTH_PASSWORD = 6;
    private static final int MIN_LENGTH_WEBSITE = 10;
    private static final int MAX_LENGTH_WEBSITE = 200;
    private static final int MIN_LENGTH_DESCRIPTION = 10;
    private static final int MAX_LENGTH_DESCRIPTION = 250;
    private static final int MIN_LENGTH_USERNAME = 3;
    private static final int MAX_LENGTH_USERNAME = 50;

    private static final String WEB_SITE_LENGTH_MESSAGE = "The field [website] must be between " + MIN_LENGTH_WEBSITE + " and " + MAX_LENGTH_WEBSITE;
    private static final String DESCRIPTION_LENGTH_MESSAGE = "The field [description] must be between " + MIN_LENGTH_DESCRIPTION + " and " + MAX_LENGTH_DESCRIPTION;
    private static final String NAME_LENGTH_MESSAGE = "The field [name] must be between " + MIN_LENGTH_NAME + " and " + MAX_LENGTH_NAME;
    private static final String EMAIL_LENGTH_MESSAGE = "The field [email] must be between " + MIN_LENGTH_EMAIL + " and " + MAX_LENGTH_EMAIL;
    private static final String USERNAME_LENGTH_MESSAGE = "The field [username] must be between " + MIN_LENGTH_USERNAME + " and " + MAX_LENGTH_USERNAME;
    private static final String PASSWORD_LENGTH_MESSAGE = "The field [message] must be between " + MIN_LENGTH_PASSWORD + " and " + MAX_LENGTH_PASSWORD +  " characters";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "The field [name] is required")
    @Length(min = MIN_LENGTH_NAME, max = MAX_LENGTH_NAME, message = NAME_LENGTH_MESSAGE)
    private String name;

    @NotBlank(message = "The field [username] is required")
    @Pattern(regexp = "\\S+", message = "The field [name] dosn't be have space characters")
    @Length(min = MIN_LENGTH_USERNAME, max = MAX_LENGTH_USERNAME, message = USERNAME_LENGTH_MESSAGE)
    private String username;

    @NotBlank(message = "The field [email] is required")
    @Email(message="The field [email] must be a valid email address")
    @Length(min = MIN_LENGTH_EMAIL, max = MAX_LENGTH_EMAIL, message = EMAIL_LENGTH_MESSAGE)
    private String email;

    @NotBlank(message = "The field [password] is required")
    @Length(min = MIN_LENGTH_PASSWORD, max = MAX_LENGTH_PASSWORD, message = PASSWORD_LENGTH_MESSAGE)
    private String password;

    @NotBlank(message = "The field [website] is required")
    @Length(min = MIN_LENGTH_WEBSITE, max = MAX_LENGTH_WEBSITE, message = WEB_SITE_LENGTH_MESSAGE)
    private String website;

    private String description;

    @CreationTimestamp
    private LocalDateTime created_at;

}
