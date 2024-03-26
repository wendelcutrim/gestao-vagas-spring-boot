package com.br.gestaovagas.gestaovagas.modules.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "job")
public class JobEntity {
    private static final int MIN_LENGTH_DESCRIPTION = 10;
    private static final int MAX_LENGTH_DESCRIPTION = 250;
    private static final int MIN_LENGTH_BENEFITS = 5;
    private static final int MAX_LENGTH_BENEFITS = 350;
    private static final int MIN_LENGTH_LEVEL = 2;
    private static final int MAX_LENGTH_LEVEL = 20;

    private static final String DESCRIPTION_LENGTH_MESSAGE = "The field [description] must be between " + MIN_LENGTH_DESCRIPTION + " and " + MAX_LENGTH_DESCRIPTION;
    private static final String BENEFTIS_LENGTH_MESSAGE = "The field [benefits] must be between " + MIN_LENGTH_BENEFITS + " and " + MAX_LENGTH_BENEFITS;
    private static final String LEVEL_LENGTH_MESSAGE = "The field [level] must be between " + MIN_LENGTH_LEVEL + " and " + MAX_LENGTH_LEVEL;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "The field [description] is required")
    @Length(min = MIN_LENGTH_DESCRIPTION, max = MAX_LENGTH_DESCRIPTION, message = DESCRIPTION_LENGTH_MESSAGE)
    private String description;

    @NotBlank(message = "The field [benefits] is required")
    @Length(min = MIN_LENGTH_BENEFITS, max = MAX_LENGTH_BENEFITS, message = BENEFTIS_LENGTH_MESSAGE)
    private String benefits;

    @NotBlank(message = "The field [level] is required")
    @Length(min = MIN_LENGTH_LEVEL, max = MAX_LENGTH_LEVEL, message = LEVEL_LENGTH_MESSAGE)
    private String level;

    @Column(name = "company_id")
    private UUID companyId;

    @ManyToOne()
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity companyEntity;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
