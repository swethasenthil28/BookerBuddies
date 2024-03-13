package org.bookerbuddies.bookease.coupon;

import lombok.AllArgsConstructor;
import org.bookerbuddies.bookease.coupon.exception.CouponAlreadyExistException;
import org.bookerbuddies.bookease.coupon.exception.CouponNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CouponController {
    @Autowired
    CouponService couponService;

    @PostMapping("newCoupon")
    public String createNewCoupon(Coupon newCoupon) throws CouponAlreadyExistException {
        return couponService.addNewCoupon(newCoupon);
    }

    @DeleteMapping("coupon/{couponCode}")
    public String deleteCoupon(@PathVariable("couponCode") String couponCode) throws CouponNotFoundException {
        return couponService.deleteCoupon(couponCode);
    }
    @PatchMapping("update")
    public Coupon updateCoupon(Coupon updateCoupon) throws CouponNotFoundException{
        return couponService.updateCouponDetails(updateCoupon);
    }

}
