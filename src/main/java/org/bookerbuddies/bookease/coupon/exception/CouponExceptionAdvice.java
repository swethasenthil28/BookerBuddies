package org.bookerbuddies.bookease.coupon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CouponExceptionAdvice {
    @ExceptionHandler(value = {CouponAlreadyExistException.class})
    public ResponseEntity<String> accountExceptionHandler(CouponAlreadyExistException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {CouponNotFoundException.class})
    public ResponseEntity<String> accountExceptionHandler(CouponNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {CouponExpiredException.class})
    public ResponseEntity<String> accountExceptionHandler(CouponExpiredException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
