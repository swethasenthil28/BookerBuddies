package org.bookerbuddies.bookease.coupon;

import org.bookerbuddies.bookease.coupon.exception.CouponAlreadyExistException;
import org.bookerbuddies.bookease.coupon.exception.CouponNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImplementation implements CouponService{

    @Autowired
    CouponRepository couponRepository;
    @Override
    public String addNewCoupon(Coupon newCoupon) throws CouponAlreadyExistException {
        Coupon findCoupon = couponRepository.findByCouponCode(newCoupon.getCouponCode());

        if(findCoupon != null){
            throw new CouponAlreadyExistException("Coupon code "+newCoupon.getCouponCode()+" already exist");
        }
        this.couponRepository.save(newCoupon);
        return "New coupon added";
    }

    @Override
    public String deleteCoupon(String couponName) throws CouponNotFoundException {

        Coupon findCoupon = couponRepository.findByCouponCode(couponName);

        if(findCoupon == null){
            throw new CouponNotFoundException("Coupon code "+couponName+" does not exist");
        }
        couponRepository.deleteById(findCoupon.getId());

        return "Deleted the coupon :"+ couponName;
    }

    @Override
    public Coupon updateCouponDetails(Coupon updateCoupon) throws  CouponNotFoundException{
        Coupon findCoupon = couponRepository.findByCouponCode(updateCoupon.getCouponCode());
        if(findCoupon == null) {
            throw new CouponNotFoundException("Coupon code with id" + updateCoupon.getId() + " already exist");
        }
        couponRepository.save(updateCoupon);
        return updateCoupon;
    }


}
