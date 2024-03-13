package org.bookerbuddies.bookease.owner;

import org.bookerbuddies.bookease.coupon.Coupon;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {
    Owner findByEmailAndPassword(String email, String password);
    
}
