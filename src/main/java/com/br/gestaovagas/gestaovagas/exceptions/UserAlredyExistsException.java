package com.br.gestaovagas.gestaovagas.exceptions;

public class UserAlredyExistsException extends RuntimeException{
    public UserAlredyExistsException() {
        super("User already exists");
    }
}
