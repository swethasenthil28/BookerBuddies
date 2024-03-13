package org.bookerbuddies.bookease.payment;

import jakarta.persistence.*;
import lombok.*;
import org.bookerbuddies.bookease.booking.Booking;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter

public class Payment {
    @Id
    @GeneratedValue //(strategy = GenerationType.AUTO)
    private Integer paymentId;
    private Integer senderId;
    private Integer receiverId;
    private Double amount;
    private String accountType;
    private String couponCode;

    public Payment(Integer senderId, Integer receiverId, Double amount, String accountType, String couponCode) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.accountType = accountType;
        this.couponCode = couponCode;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", amount=" + amount +
                ", accountType='" + accountType + '\'' +
                ", couponCode='" + couponCode + '\'' +
                '}';
    }
}
