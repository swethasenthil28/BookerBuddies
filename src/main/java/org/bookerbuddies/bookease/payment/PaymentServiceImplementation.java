//package org.bookerbuddies.bookease.payment;
//
//import org.bookerbuddies.bookease.account.Account;
//import org.bookerbuddies.bookease.account.AccountRepository;
//import org.bookerbuddies.bookease.coupon.Coupon;
//import org.bookerbuddies.bookease.coupon.CouponRepository;
//import org.bookerbuddies.bookease.coupon.exception.CouponExpiredException;
//import org.bookerbuddies.bookease.coupon.exception.CouponNotFoundException;
//import org.bookerbuddies.bookease.payment.dto.Cancellation;
//import org.bookerbuddies.bookease.payment.dto.Transaction;
//import org.bookerbuddies.bookease.payment.exception.PaymentInsufficientBalanceException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.security.auth.login.AccountNotFoundException;
//import java.time.LocalDate;
//import java.util.List;
//
//@Service
//public class PaymentServiceImplementation implements PaymentService {
//
//    @Autowired
//    AccountRepository accountRepository;
//    @Autowired
//    PaymentRepository paymentRepository;
//    @Autowired
//    AccountService accountService;
//    @Autowired
//    CouponRepository couponRepository;
//
//
//
//    //    @Transactional(rollbackOn = { PaymentService.class })
//    @Override
//    public Double transaction(Transaction transaction) throws PaymentInsufficientBalanceException, AccountNotFoundException, CouponNotFoundException, CouponExpiredException {
//
//
//        Account fromAccount =  accountService.getAccountDetails(transaction.getSenderId());
//        Account toAccount =  accountService.getAccountDetails(transaction.getReceiverId());
//        Double transferAmount = transaction.getAmount();
//        String couponCode= null;
//        if(transaction.getCouponCode() != null){
//
//
//
//            Coupon getCoupon = couponRepository.findByCouponCode(transaction.getCouponCode());
//            if(getCoupon == null){
//                throw new CouponNotFoundException("Coupon with code "+transaction.getCouponCode()+" not found");
//            }
//            if(getCoupon.getExpiryDate().isAfter(LocalDate.now())){
//                throw new CouponExpiredException("Coupon code "+getCoupon.getCouponCode()+" is expired");
//            }
//            transferAmount =  transaction.getAmount() - ( transaction.getAmount() *  getCoupon.getDiscount());
//
//            if(transferAmount > fromAccount.getBalance()){
//                throw new PaymentInsufficientBalanceException("Insufficient Balance for account id : "+ fromAccount.getBalance());
//            }
//            couponCode = getCoupon.getCouponCode();
//        }
//
//
//        fromAccount.setBalance(fromAccount.getBalance() - transferAmount);
//        toAccount.setBalance(toAccount.getBalance()+transaction.getAmount());
//        accountRepository.save(fromAccount);
//        accountRepository.save(toAccount);
//        Payment newPayment = new Payment( fromAccount.getAccountId(), toAccount.getAccountId(),transferAmount,"client", couponCode);
//        paymentRepository.save(newPayment);
//
//        return fromAccount.getBalance();
//
//    }
//
//    @Override
//    public List<Payment> payments(String typeOfPerson, Integer id) {
//        return paymentRepository.findByAccountTypeAndSenderId(typeOfPerson, id);
//    }
//
//    @Override
//    public Double paymentsCancellation(Cancellation cancellation) throws AccountNotFoundException, PaymentInsufficientBalanceException {
//
//        LocalDate bookingDate = cancellation.getBookingDate();
//        LocalDate dateOfBooking = cancellation.getDataOfBooking();
//
//        int dataOfDifference = dateOfBooking.compareTo(bookingDate);
//        double currentDate =  (double) LocalDate.now().getDayOfMonth();
//
//        Double interest = ((double)dataOfDifference/currentDate)*0.1  ;
//        Payment paymentDetails = paymentRepository.findBySenderId(cancellation.getClientId());
//
//
//        Double amount =   paymentDetails.getAmount();
//
//        Double refundAmount = amount*interest;
//
//        Account clientAccount =  accountService.getAccountDetails(cancellation.getClientId());
//        Account ownerAccount = accountService.getAccountDetails(cancellation.getOwnerId());
//
//        if(ownerAccount.getBalance() < refundAmount){
//            throw new PaymentInsufficientBalanceException("Insufficient Balance for account id : "+ownerAccount.getBalance());
//        }
//
//        clientAccount.setBalance(clientAccount.getBalance() + refundAmount);
//        ownerAccount.setBalance(ownerAccount.getBalance() - refundAmount);
//
//        Payment newPayment = new Payment( ownerAccount.getAccountId(), clientAccount.getAccountId(),refundAmount,"owner", null);
//        paymentRepository.save(newPayment);
//
//        accountRepository.save(clientAccount);
//        accountRepository.save(ownerAccount);
//        return refundAmount;
//
//    }
//
//
//}
