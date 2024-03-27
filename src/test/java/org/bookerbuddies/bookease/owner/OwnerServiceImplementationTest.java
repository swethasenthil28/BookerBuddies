package org.bookerbuddies.bookease.owner;

import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.coupon.Coupon;
import org.bookerbuddies.bookease.coupon.exception.CouponAlreadyExistException;
import org.bookerbuddies.bookease.coupon.exception.CouponNotFoundException;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.meetingroom.MeetingRoomRepository;
import org.bookerbuddies.bookease.meetingroom.MeetingRoomService;
import org.bookerbuddies.bookease.meetingroom.MeetingRoomServiceImplementation;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNullException;
import org.bookerbuddies.bookease.owner.exception.OwnerIdNotFoundException;
import org.bookerbuddies.bookease.owner.exception.OwnerNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OwnerServiceImplementationTest {
    @Autowired
    OwnerServiceImplementation ownerServiceImplementation;

    @Autowired
    MeetingRoomServiceImplementation meetingRoomServiceImplementation;

    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    @Test
    void when_ownerLogin_is_called_with_tested_with_valid_credentials() throws OwnerNotFoundException {
        Owner owner = ownerServiceImplementation.ownerLogin("swetha@gmail.com", "12345");
        assertNotNull(owner);
    }

    @Test
    void when_OwnerLogin_is_tested_with_invalid_credentials_it_should_throw_OwnerNotFoundException() {
        assertThrows(OwnerNotFoundException.class, () -> {
            ownerServiceImplementation.ownerLogin("swe@gmail.com", "password");
        });
    }

    @Test
    void when_getOwnerById_is_called_with_ownerid_it_should_return_owner_with_that_id() throws OwnerIdNotFoundException {
        Owner expected = Owner.builder().name("swetha").id(1).email("swetha@gmail.com").password("12345").build();
        expected = ownerRepository.save(expected);
        Owner actual = ownerServiceImplementation.getOwnerById(expected.getId());
        Assertions.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    void when_getOwnerById_is_called_with_non_existing_owner_id_it_should_throw_OwnerIdNotFoundException() {
        //Owner expected = Owner.builder().name("swetha").id(1).email("swetha@gmail.com").password("12345").build();
        Integer nonExistingOwnerId = 2000;
        Exception exception = assertThrows(OwnerIdNotFoundException.class, () -> {
            ownerServiceImplementation.getOwnerById(nonExistingOwnerId);
        });
        Assertions.assertEquals("Owner with id : " + nonExistingOwnerId + " does not exist", exception.getMessage());
    }

//    @Test
//    void when_addOwner_is_called_with_ownerDto_it_should_add_new_owner() {
//        Integer ownerId = 1;
//        String name = "Swetha";
//        String email = "admin@gmail.com";
//        String password = "admin";
//        Account account = new Account(1, "SwethaSenthil", 2000.0, "Owner");
//
//        Owner addedOwner = ownerServiceImplementation.addOwner(ownerId, name, email, password, account);
//        ownerRepository.save(addedOwner);
//        assertNotNull(addedOwner);
//        assertEquals(ownerId, addedOwner.getId());
//    }

    @Test
    void when_createNewMeetingRoom_is_called_with_new_meeting_room_it_should_create_new_meeting_room() throws MeetingRoomAlreadyExistException, MeetingRoomNullException {

        // MeetingRoom meetingRoom=new MeetingRoom(12,"Meetinghall",20,2,"video",LocalDate.of(2024,02,23),200.0,true);
        MeetingRoom meetingRoom = MeetingRoom.builder().name("Meetingh").id(25).capacity(10).costOfRoom(12000.0).build();
        meetingRoom = ownerServiceImplementation.createNewMeetingRoom(meetingRoom);
        meetingRoomRepository.save(meetingRoom);
        //MeetingRoom newMeetingRoom=meetingRoomRepository.findById(meetingRoom.getId()).orElseThrow();
      //  Assertions.assertNotNull(meetingRoom);
        Assertions.assertEquals("Meetingh", meetingRoom.getName());
    }


//    @Test
//    void when_createNewMeetingRoom_is_called_by_passing_existing_values_it_should_throw_MeetingRoomAlreadyExistException() {
//        MeetingRoom existingMeetingRoom = new MeetingRoom();
//        existingMeetingRoom.setId(1);
//        MeetingRoomAlreadyExistException exception = assertThrows(MeetingRoomAlreadyExistException.class, () -> {
//           ownerServiceImplementation.createNewMeetingRoom(existingMeetingRoom);
//        });
//        String expectedMessage = "Meeting room with this id already exists";
//        String actualMessage = exception.getMessage();
//        assert(actualMessage.contains(expectedMessage));
//    }
//    @Test
//    void when_getAllMeetingrooms_is_called_it_should_return_all_the_meeting_rooms() {
//        MeetingRoom expected = MeetingRoom.builder().name("Tangent").capacity(30).type("Birthday").build();
//        meetingRoomRepository.save(expected);
//        MeetingRoom actual = this.ownerServiceImplementation.getAllMeetingrooms().get(0);
//        assertEquals(expected.getName(), actual.getName());
//    }

    @Test
    void when_getMeetingRoomById_is_called_with_non_existing_meeting_room_Id_then_it_should_throw_MeetingRoomNotFoundException() {
        Integer nonExistingMeetingRoomId = 100;
        Exception exception = assertThrows(MeetingRoomNotFoundException.class, () -> {
            ownerServiceImplementation.getMeetingRoomById(nonExistingMeetingRoomId);
        });

        assertEquals("Room with id : " + nonExistingMeetingRoomId + " does not exist", exception.getMessage());
    }
//    @Test
//    void when_getMeetingRoomById_is_called_with_meeting_room_id_it_should_return_meeting_room_with_that_id() {
//        MeetingRoom expected = MeetingRoom.builder().name("Tangent").capacity(30).type("Birthday").build();
//        meetingRoomRepository.save(expected);
//        MeetingRoom actual = this.ownerServiceImplementation.getAllMeetingrooms().get(0);
//        assertEquals(expected.getName(), actual.getName());
//    }
//
//    @Test
//    void when_deleteMeetingRoomById_is_called_with_meetingroom_id_it_should_delete_meetingroom_with_matching_id() throws MeetingRoomNotFoundException {
//      // MeetingRoom meetingRoom= new MeetingRoom(99,"Summit",20,2,"Meet",LocalDate.of(2024,04,30),1000.0,true);
//        MeetingRoom meetingRoom=MeetingRoom.builder().name("Meet").capacity(20).costOfRoom(1000.0).build();
//         ownerServiceImplementation.deleteMeetingRoomById(meetingRoom.getId());
//        Assertions.assertNull(meetingRoomRepository.findByName("Meet"));
//    }
    @Test
void when_deleteMeetingRoomById_is_called_with_meetingroom_id_it_should_delete_meetingroom_with_matching_id() throws MeetingRoomNotFoundException {

    MeetingRoom meetingRoom = MeetingRoom.builder().id(100).name("Ace").costOfRoom(2000.0).build();
    meetingRoom = meetingRoomRepository.save(meetingRoom);
    ownerServiceImplementation.deleteMeetingRoomById(meetingRoom.getId());
    Assertions.assertNull(meetingRoomRepository.findById(meetingRoom.getId()).orElse(null));
}

    @Test
    void when_deleteMeetingRoomById_is_called_with_non_existing_meeting_room_id_it_should_throw_MeetingRoomNotFoundException() {
        MeetingRoom meetingRoom = MeetingRoom.builder().id(999).name("Hall").costOfRoom(500.0).build();
        meetingRoomRepository.save(meetingRoom);

        String expectedErrorMessage = "Meeting Room not found with id: 91";
        String actualErrorMessage = null;

        try {
           ownerServiceImplementation.deleteMeetingRoomById(91);
        } catch (MeetingRoomNotFoundException e) {
            actualErrorMessage = e.getMessage();
        }

        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    void when_updateMeetingRoom_is_called_with_non_existing_meeting_room_then_it_should_throw_MeetingRoomNotFoundException() {

        String nonExistingMeetingRoomName = "NonExistingRoom";
        String type = "Conference";
        LocalDate date = LocalDate.of(2023, 12, 15);
        Double costOfRoom = 700.0;

        MeetingRoomNotFoundException exception = assertThrows(MeetingRoomNotFoundException.class, () -> {
            ownerServiceImplementation.updateMeetingRoom(nonExistingMeetingRoomName, type, date, costOfRoom);
        });

        assertEquals("Meeting room with name : " + nonExistingMeetingRoomName + " does not exist", exception.getMessage());
    }

}

