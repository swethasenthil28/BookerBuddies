package org.bookerbuddies.bookease.owner;

import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.account.AccountRepository;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.client.exception.ClientException;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.meetingroom.MeetingRoomRepository;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNullException;
import org.bookerbuddies.bookease.owner.exception.OwnerIdNotFoundException;
//import org.bookerbuddies.bookease.payment.PaymentRepository;
import org.bookerbuddies.bookease.owner.exception.OwnerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImplementation implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MeetingRoomRepository meetingRoomRepository;

    @Override
    public Owner ownerLogin(String email, String password) throws OwnerNotFoundException {
        Owner owner = this.ownerRepository.findByEmailAndPassword(email, password);

        if (owner != null) {
            return owner;
        } else {
            throw new OwnerNotFoundException("Owner not found or invalid credentials.");
        }
    }
    @Override
    public Owner addOwner(Integer ownerId, String name, String email, String password, Account account) {
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setName(name);
        owner.setEmail(email);
        owner.setPassword(password);
        owner.setAccount(account);
        return this.ownerRepository.save(owner);
    }

    @Override
    public Owner getOwnerById(Integer ownerId) throws OwnerIdNotFoundException {
        Optional<Owner> owner = this.ownerRepository.findById(ownerId);
        if (owner.isEmpty()) {
            throw new OwnerIdNotFoundException("Owner with id : " + ownerId + " does not exist");
        }
        return owner.get();
    }

    @Override
    public MeetingRoom createNewMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistException, MeetingRoomNullException {
        if (meetingRoom == null) {
            throw new MeetingRoomNullException("Meeting room cannot be null");
        }
        if(meetingRoomRepository.existsById(meetingRoom.getId())){
            throw new MeetingRoomAlreadyExistException("Meeting room with this id already exists");
        }
        return meetingRoomRepository.save(meetingRoom);
    }

    @Override
    public List<MeetingRoom> getAllMeetingrooms() {
        return meetingRoomRepository.findAll();
    }

    @Override
    public MeetingRoom getMeetingRoomById(Integer meetingRoomId) throws MeetingRoomNotFoundException {
        Optional<MeetingRoom> meetingRoom = this.meetingRoomRepository.findById(meetingRoomId);
        if (meetingRoom.isEmpty()) {
            throw new MeetingRoomNotFoundException("Room with id : " + meetingRoomId + " does not exist");
        }
        return meetingRoom.get();
    }

    @Override
    public MeetingRoom updateMeetingRoom(String name, String type, LocalDate date, Double costOfRoom) throws MeetingRoomNotFoundException {
        MeetingRoom meetingRoomToUpdate = meetingRoomRepository.findByName(name);
        if (meetingRoomToUpdate == null) {
            throw new MeetingRoomNotFoundException("Meeting room with name : " + name + " does not exist");
        }
        meetingRoomToUpdate.setType(type);
        meetingRoomToUpdate.setDate(date);
        meetingRoomToUpdate.setCostOfRoom(costOfRoom);

        return meetingRoomRepository.save(meetingRoomToUpdate);
    }

    public MeetingRoom deleteMeetingRoomById(Integer id) throws MeetingRoomNotFoundException {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(id)
                .orElseThrow(() -> new MeetingRoomNotFoundException("Meeting Room not found with id: " + id));

        meetingRoomRepository.delete(meetingRoom);

        return meetingRoom;
    }
}