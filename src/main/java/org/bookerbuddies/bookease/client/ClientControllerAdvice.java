package org.bookerbuddies.bookease.client;

import org.bookerbuddies.bookease.client.exception.ClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClientControllerAdvice {
    @ExceptionHandler(value = {ClientException.class})
    public ResponseEntity<String> clientExceptionHandler(ClientException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
