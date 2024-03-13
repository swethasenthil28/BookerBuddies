package org.bookerbuddies.bookease.meetingroom;

import org.bookerbuddies.bookease.booking.Booking;
import org.bookerbuddies.bookease.booking.BookingRepository;
import org.bookerbuddies.bookease.booking.exceptions.BookingNotFoundException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingRoomServiceImplementation implements MeetingRoomService{
    @Autowired
    private MeetingRoomRepository meetingRoomRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<MeetingRoom> getAllMeetingRooms(){
        return this.meetingRoomRepository.findAll();
    }

    @Override
    public MeetingRoom getMeetingRoomById(Integer meetingRoomId) throws MeetingRoomNotFoundException{
        Optional<MeetingRoom> meetingRoom =this.meetingRoomRepository.findById(meetingRoomId);
        if(meetingRoom.isEmpty()){
            throw  new MeetingRoomNotFoundException("Room with id : "+ meetingRoomId+" does not exist");
        }
        return  meetingRoom.get();
    }
//    @Override
//    public Boolean addBookingInMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistException, MeetingRoomNotFoundException {
//        if(meetingRoom==null){
//            throw new MeetingRoomNotFoundException("Meeting room not found");
//        }
//        else if(meetingRoom.getIsAvailable().equals(false)){
//            throw new MeetingRoomAlreadyExistException("Meeting room with Id "+meetingRoom.getId()+" already exist");
//        }
//        meetingRoom.setIsAvailable(false);
//
//        this.meetingRoomRepository.save(meetingRoom);
//
//        return true;
//
//    }
@Override
public Boolean addBookingInMeetingRoom(MeetingRoom meetingRoom,Booking booking) throws MeetingRoomAlreadyExistException {
    if(meetingRoom.getIsAvailable().equals(false)){
        throw new MeetingRoomAlreadyExistException("Meeting room with Id "+meetingRoom.getId()+" already booked");
    }
    meetingRoom.setIsAvailable(false);
    bookingRepository.save(booking);

    meetingRoom.setBooking(booking);
    this.meetingRoomRepository.save(meetingRoom);

    return true;
}


    @Override
    public Boolean updateBookingInMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomNotFoundException {
        if(meetingRoom.getId()==null){
            throw new MeetingRoomNotFoundException("Meeting Room Not found");
        }
        meetingRoomRepository.save(meetingRoom);
        return true;
    }

    @Override
    public List<MeetingRoom> getAllMeetingRoomsByDateAndType(LocalDate bookingDate, String type) {
        return this.meetingRoomRepository.findByDateAndType(bookingDate,type)
                .stream()
                .filter(meetingRoom -> meetingRoom.getIsAvailable().equals(true))
                .toList();
    }

    @Override
    public Booking getBookingByMeetingRoomId(Integer meetingRoomId) throws BookingNotFoundException {
        Optional<MeetingRoom> meetingRoom = this.meetingRoomRepository.findById(meetingRoomId);
        if (meetingRoom.isEmpty()) {
            throw new BookingNotFoundException("Booking not found for the meeting room with Id " + meetingRoomId);
        }
        return meetingRoom.get().getBooking();

    }
}

