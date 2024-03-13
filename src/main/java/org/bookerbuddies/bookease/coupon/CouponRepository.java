package org.bookerbuddies.bookease.coupon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {
    Coupon findByCouponCode(String couponCode);
}
