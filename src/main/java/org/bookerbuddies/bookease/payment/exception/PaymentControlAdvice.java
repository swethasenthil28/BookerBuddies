package org.bookerbuddies.bookease.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentControlAdvice {

    @ExceptionHandler(value = {PaymentInsufficientBalanceException.class})
    public ResponseEntity<String> accountExceptionHandler(PaymentInsufficientBalanceException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
