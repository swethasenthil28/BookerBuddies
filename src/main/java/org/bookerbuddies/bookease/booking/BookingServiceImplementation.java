package org.bookerbuddies.bookease.booking;

import org.bookerbuddies.bookease.booking.exceptions.BookingNotFoundException;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.meetingroom.MeetingRoomService;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookingServiceImplementation implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MeetingRoomService meetingRoomService;


    @Override
    public Boolean addBooking(Integer meetingRoomId,Booking booking) throws MeetingRoomAlreadyExistException, MeetingRoomNotFoundException {
        MeetingRoom  meetingRoom=meetingRoomService.getMeetingRoomById(meetingRoomId);
        if(meetingRoom == null)
            throw new MeetingRoomNotFoundException("No Meeting room found");
        Boolean meetingRoomStatus = meetingRoomService.addBookingInMeetingRoom(meetingRoom,booking);
        return !meetingRoomStatus.equals(false);

    }
    @Override
    public Booking getBookingForMeetingRoom(Integer meetingRoomId) throws BookingNotFoundException {
        return  meetingRoomService.getBookingByMeetingRoomId(meetingRoomId);
    }

    @Override
    public Boolean cancelBooking(Integer meetingRoomId)  throws MeetingRoomNotFoundException {
        MeetingRoom meetingRoom =meetingRoomService.getMeetingRoomById(meetingRoomId);
        meetingRoom.setBooking(null);
        meetingRoom.setIsAvailable(true);
        meetingRoomService.updateBookingInMeetingRoom(meetingRoom);
        return true;

    }

}
