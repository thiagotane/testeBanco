package com.example.testeSantander.exception;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(Integer id) {
        super("Não foi encontrado o cliente com id: " + id);
    }
}