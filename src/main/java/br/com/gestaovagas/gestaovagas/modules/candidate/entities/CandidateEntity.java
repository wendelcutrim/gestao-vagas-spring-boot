package br.com.gestaovagas.gestaovagas.modules.candidate.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CandidateEntity {
    private String name;
    private static final int MAX_LENGTH_PASSWORD = 50;
    private static final int MIN_LENGH_PASSWORD = 6;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "The field [username] dosn't be have space characters")
    private String username;

    @Email(message = "The field [email] must be a valid email address")
    private String email;

    @Length(min = MIN_LENGH_PASSWORD, max = MAX_LENGTH_PASSWORD, message = "The field [password] must be between " + MIN_LENGH_PASSWORD + " and " + MAX_LENGTH_PASSWORD +  " characters")
    private String password;

    private String description;

    private String curriculum;
}
