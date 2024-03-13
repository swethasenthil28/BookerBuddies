package org.bookerbuddies.bookease.booking;

import org.bookerbuddies.bookease.booking.exceptions.BookingNotFoundException;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {
    public Boolean addBooking(Integer meetingRoomId, Booking booking) throws MeetingRoomAlreadyExistException, MeetingRoomNotFoundException;
    public Booking getBookingForMeetingRoom(Integer meetingRoomId) throws BookingNotFoundException;
    public Boolean cancelBooking(Integer meetingRoomId) throws MeetingRoomNotFoundException;

}
