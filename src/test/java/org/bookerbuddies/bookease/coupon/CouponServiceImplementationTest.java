package org.bookerbuddies.bookease.coupon;

import org.bookerbuddies.bookease.coupon.exception.CouponAlreadyExistException;
import org.bookerbuddies.bookease.coupon.exception.CouponNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CouponServiceImplementationTest {
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CouponService couponService;

    @Test
    void when_addNewCoupon_is_Called_with_new_coupon_name_it_should_add_new_coupon_on_repo() throws CouponAlreadyExistException {
        Coupon newCoupon = Coupon.builder().couponCode("FFFfE").expiryDate(LocalDate.of(2024, 12, 22)).discount(0.90).build();
        couponService.addNewCoupon(newCoupon);
        Assertions.assertNotNull(couponRepository.findByCouponCode(newCoupon.getCouponCode()));
    }

    @Test
    void when_addNewCoupon_is_called_with_the_existing_coupon_it_should_throw_exception_CouponAlreadyExistException() {

        couponRepository.save(Coupon.builder().couponCode("XYZZ").expiryDate(LocalDate.of(2021, 4, 9))
                .discount(0.50).build());

        Coupon newCoupon = Coupon.builder().couponCode("XYZZ").expiryDate(LocalDate.of(2021, 4, 9))
                .discount(0.50).build();

        String expected = null;
        String actual = "Coupon code XYZZ already exist";
        try {
            couponService.addNewCoupon(newCoupon);
        } catch (CouponAlreadyExistException e) {
            expected = e.getMessage();
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void when_deleteCoupon_is_Called_with_couponId_it_should_remove_coupon_with_matching_id() throws CouponNotFoundException {

        couponRepository.save(Coupon.builder().couponCode("BBCC").expiryDate(LocalDate.of(2021, 4, 9))
                .discount(0.50).build());

        couponService.deleteCoupon("BBCC");
        Assertions.assertNull(couponRepository.findByCouponCode("BBCC"));

    }

    @Test
    void when_deleteCoupon_is_Called_with_XEEE_it_should_throw_CouponNotFoundException() {
        couponRepository.save(Coupon.builder().couponCode("XAAA").expiryDate(LocalDate.of(2021, 4, 9))
                .discount(0.50).build());
        String expected = null;
        String actual = "Coupon code XEEE does not exist";

        try {
            couponService.deleteCoupon("XEEE");
        } catch (CouponNotFoundException e) {
            expected = e.getMessage();
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void updateCouponDetails_is_called_with_coupon_details_then_it_should_remove_the_coupon_from_the_database() throws CouponNotFoundException {

        Coupon newCoupon = Coupon.builder().couponCode("FFFfE").expiryDate(LocalDate.of(2024, 03, 10)).discount(.7).build();
        couponService.updateCouponDetails(newCoupon);
        Assertions.assertTrue(couponRepository.findByCouponCode("XYZZ").getDiscount().equals(0.5));
    }
}