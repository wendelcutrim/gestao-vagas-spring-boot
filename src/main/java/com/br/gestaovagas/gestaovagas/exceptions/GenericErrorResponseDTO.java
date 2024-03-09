package com.br.gestaovagas.gestaovagas.exceptions;

import lombok.Data;

@Data
public class GenericErrorResponseDTO {
    private String message;
    private Integer statusCode;
}
