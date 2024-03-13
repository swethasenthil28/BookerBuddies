package org.bookerbuddies.bookease.booking;

import org.bookerbuddies.bookease.booking.exceptions.BookingNotFoundException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PatchMapping("addBookingInMeetingRoom/{meetingRoomId}")
    public Boolean addBookingInMeetingRoom(@PathVariable("meetingRoomId") Integer meetingRoomId ,@RequestBody Booking booking) throws MeetingRoomAlreadyExistException, MeetingRoomNotFoundException {
        return bookingService.addBooking(meetingRoomId,booking);
    }
    @GetMapping("bookingsByMeetingRoom/{meetingRoomId}")
    public Booking getBookingByMeetingRoom(@RequestParam Integer meetingRoomId) throws BookingNotFoundException {
        return bookingService.getBookingForMeetingRoom(meetingRoomId);
    }

    @PatchMapping("cancelBookingByMeetingRoomId/{meetingRoomId}")
    public Boolean cancelBooking(@RequestParam Integer meetingRoomId) throws MeetingRoomNotFoundException {
        bookingService.cancelBooking(meetingRoomId);
        return true;
    }
}