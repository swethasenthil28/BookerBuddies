package org.bookerbuddies.bookease.meetingroom;

import org.bookerbuddies.bookease.booking.Booking;
import org.bookerbuddies.bookease.booking.exceptions.BookingNotFoundException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.bookerbuddies.bookease.owner.OwnerServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MeetingRoomServiceImplementationTest {
    @Autowired
    MeetingRoomServiceImplementation meetingroomserviceimplementation;
    @Autowired
    OwnerServiceImplementation ownerServiceImplementation;
    @Test
    void when_getMeetingRoomById_is_called_with_meetingroom_id_it_should_return_meetingroom_with_that_id() {
        MeetingRoom expected = MeetingRoom.builder().id(1).name("Tangent").capacity(30).type("Birthday").build();
        MeetingRoom actual = this.ownerServiceImplementation.getAllMeetingrooms().get(0);
        assertEquals(expected.getName(), actual.getName());
    }
    @Test
    void when_getBookingByMeetingRoomId_is_called_with_meetingRoomId_52_then_it_should_return_booking_for_the_meetingRoom() throws BookingNotFoundException{
        Booking expected = Booking.builder().id(302).bookingDate(LocalDate.of(2024, 2, 28)).bookedDate(LocalDate.of(2024, 2, 23)).status(true).eventDescription("Meet").payment(null).build();
        Booking actual = meetingroomserviceimplementation.getBookingByMeetingRoomId(52);
        assertEquals(actual.getId(),expected.getId());
    }
    @Test
    void when_getAllMeetingRoomsByDateAndType_is_called_with_Date_and_type_then_it_should_return_list_of_rooms_available_for_date_type(){
        List<MeetingRoom> expected = Arrays.asList(MeetingRoom.builder().id(1).name("summit").capacity(8).type("video").date(LocalDate.of(2024, 2, 24)).costOfRoom(56900.0).isAvailable(true).booking(null).build(),MeetingRoom.builder().id(53).name("summit").capacity(6).type("video").date(LocalDate.of(2024, 2, 24)).costOfRoom(2000.0).isAvailable(true).booking(null).build());
        List<MeetingRoom> actual = meetingroomserviceimplementation.getAllMeetingRoomsByDateAndType(LocalDate.of(2024, 2, 24),"video");
        assertEquals(expected.get(0).getName(),actual.get(0).getName());
        assertEquals(expected.get(1).getName(),actual.get(1).getName());
        assertEquals(expected.get(0).getId(),actual.get(0).getId());
    }
}