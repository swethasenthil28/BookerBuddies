package org.bookerbuddies.bookease.owner;

import jakarta.validation.Valid;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.client.exception.ClientException;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNullException;
import org.bookerbuddies.bookease.owner.dto.Login;
import org.bookerbuddies.bookease.owner.dto.OwnerDto;
import org.bookerbuddies.bookease.owner.exception.OwnerIdNotFoundException;
import org.bookerbuddies.bookease.owner.exception.OwnerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @PostMapping("owner/login")
    public Owner ownerLogin(@Valid @RequestBody Login login)throws OwnerNotFoundException {
        return this.ownerService.ownerLogin(login.getEmail(), login.getPassword());
    }

    @PostMapping("owner")
    public Owner newOwner(@Valid @RequestBody OwnerDto ownerDto) {
        return this.ownerService.addOwner(ownerDto.getId(), ownerDto.getName(), ownerDto.getEmail(), ownerDto.getPassword(),ownerDto.getAccount());
    }

    @GetMapping("owner/{id}")
    public Owner getOwnerById(@PathVariable("id") Integer ownerId) throws OwnerIdNotFoundException {
        return this.ownerService.getOwnerById(ownerId);
    }
    @PostMapping("addNewMeetingRoom")
    public MeetingRoom createNewMeetingRoom(@RequestBody MeetingRoom meetingRoom)
//            throws MeetingRoomNullException, MeetingRoomAlreadyExistException
    {
        return ownerService.createNewMeetingRoom(meetingRoom);
    }

    @GetMapping("getMeetingRoomById/{id}")
    public MeetingRoom getMeetingRoomById(@RequestParam Integer meetingRoomId) throws MeetingRoomNotFoundException {
        return this.ownerService.getMeetingRoomById(meetingRoomId);
    }

    @GetMapping("meetingroom/name/{name}")
    public MeetingRoom getMeetingRoomByName(@PathVariable String name)throws MeetingRoomNotFoundException{
        return this.ownerService.getMeetingRoomByName(name);
    }
    @GetMapping("viewallmeetingrooms")
    public List<MeetingRoom> getAllMeetingRooms() {
        return ownerService.getAllMeetingrooms();
    }

    @PatchMapping("meetingrooms/update/{name}/{type}/{date}/{costOfRoom}")
    public MeetingRoom updateMeetingRoom(@PathVariable("name") String name, @PathVariable("type") String type, @PathVariable("date") LocalDate date, @PathVariable("costOfRoom") Double costOfRoom) throws MeetingRoomNotFoundException {
        return this.ownerService.updateMeetingRoom(name, type, date, costOfRoom);
    }


    @DeleteMapping("deleteMeetingRoomById/{id}")
    public MeetingRoom deleteMeetingRoomById(@PathVariable("id") Integer id) throws MeetingRoomNotFoundException {
        return this.ownerService.deleteMeetingRoomById(id);
    }
}
