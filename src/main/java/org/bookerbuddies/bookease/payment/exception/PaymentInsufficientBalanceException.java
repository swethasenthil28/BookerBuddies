package org.bookerbuddies.bookease.payment.exception;

public class PaymentInsufficientBalanceException extends Exception{


    public PaymentInsufficientBalanceException(String message) {
        super(message);
    }
}
