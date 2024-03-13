package org.bookerbuddies.bookease.coupon;

import org.bookerbuddies.bookease.coupon.exception.CouponAlreadyExistException;
import org.bookerbuddies.bookease.coupon.exception.CouponNotFoundException;

public interface CouponService {

    String addNewCoupon(Coupon newCoupon) throws CouponAlreadyExistException;
    String deleteCoupon(String couponCode) throws CouponNotFoundException;

    Coupon updateCouponDetails(Coupon updateCoupon) throws CouponNotFoundException;
}
