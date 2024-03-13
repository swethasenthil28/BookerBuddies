//package org.bookerbuddies.bookease.payment;
//
//
//import org.bookerbuddies.bookease.coupon.exception.CouponExpiredException;
//import org.bookerbuddies.bookease.coupon.exception.CouponNotFoundException;
//import org.bookerbuddies.bookease.payment.dto.Cancellation;
//import org.bookerbuddies.bookease.payment.dto.Transaction;
//import org.bookerbuddies.bookease.payment.exception.PaymentInsufficientBalanceException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.security.auth.login.AccountNotFoundException;
//import java.util.List;
//
//@RestController
//public class PaymentController {
//    @Autowired
//    PaymentService paymentService;
//
//    @PatchMapping("payment")
//    public Double makePayment(@RequestBody Transaction transaction)throws PaymentInsufficientBalanceException, AccountNotFoundException, CouponNotFoundException, CouponExpiredException {
//
//        return paymentService.transaction(transaction);
//    }
//
//    @GetMapping("getPayments/{type}/{id}")
//    public List<Payment> getAllPayments(@PathVariable  String type,@PathVariable Integer id){
//        return paymentService.payments(type, id);
//    }
//
//    @GetMapping("cancellation")
//    public Double bookingCancellation(@RequestBody Cancellation cancellation) throws AccountNotFoundException, PaymentInsufficientBalanceException{
//        return paymentService.paymentsCancellation(cancellation);
//    }
//
//}
