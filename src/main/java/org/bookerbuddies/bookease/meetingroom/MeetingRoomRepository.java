package org.bookerbuddies.bookease.meetingroom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom,Integer> {

List<MeetingRoom> findByDateAndType(LocalDate date,String type);
    MeetingRoom findByName(String name);
}
