//package org.bookerbuddies.bookease.payment;
//
//import org.bookerbuddies.bookease.coupon.exception.CouponExpiredException;
//import org.bookerbuddies.bookease.coupon.exception.CouponNotFoundException;
//import org.bookerbuddies.bookease.payment.dto.Cancellation;
//import org.bookerbuddies.bookease.payment.dto.Transaction;
//import org.bookerbuddies.bookease.payment.exception.PaymentInsufficientBalanceException;
//import org.springframework.stereotype.Service;
//
//import javax.security.auth.login.AccountNotFoundException;
//import java.util.List;
//
//@Service
//public interface PaymentService {
//
//    Double transaction(Transaction transaction) throws PaymentInsufficientBalanceException, AccountNotFoundException, CouponNotFoundException, CouponExpiredException;
//
//    List<Payment> payments(String typeOfPerson, Integer id );
//
//
//    Double paymentsCancellation(Cancellation cancellation) throws AccountNotFoundException, PaymentInsufficientBalanceException;
//}