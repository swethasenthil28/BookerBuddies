package org.bookerbuddies.bookease.coupon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Coupon {
    @Id
    @GeneratedValue
    private Integer id;
    private String couponCode;
    private LocalDate expiryDate;
    private Double discount;



    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", couponCode='" + couponCode + '\'' +
                ", expiryDate=" + expiryDate +
                ", discount=" + discount +
                '}'+"\n";
    }

}
