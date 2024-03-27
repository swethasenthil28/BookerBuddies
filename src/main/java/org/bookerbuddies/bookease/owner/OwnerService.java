package org.bookerbuddies.bookease.owner;

import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.client.exception.ClientException;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNullException;
import org.bookerbuddies.bookease.owner.exception.OwnerIdNotFoundException;
import org.bookerbuddies.bookease.owner.exception.OwnerNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface OwnerService {

    Owner ownerLogin(String email,String password) throws OwnerNotFoundException;
    Owner getOwnerById(Integer ownerId) throws OwnerIdNotFoundException;

    Owner addOwner(Integer ownerId, String name, String email, String password, Account account);

    MeetingRoom createNewMeetingRoom(MeetingRoom meetingRoom) ;

    List<MeetingRoom> getAllMeetingrooms();

    MeetingRoom getMeetingRoomById(Integer meetingRoomId) throws MeetingRoomNotFoundException;
    MeetingRoom getMeetingRoomByName(String name)throws MeetingRoomNotFoundException;
    MeetingRoom updateMeetingRoom(String name, String type, LocalDate date, Double costOfRoom) throws MeetingRoomNotFoundException;

    MeetingRoom deleteMeetingRoomById(Integer id) throws MeetingRoomNotFoundException;


}