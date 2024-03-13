package org.bookerbuddies.bookease.payment.dto;

import lombok.*;


@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {
    private Integer senderId;
    private Integer receiverId;
    private Double amount;
    private String couponCode;

}
