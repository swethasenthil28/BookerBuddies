package org.bookerbuddies.bookease.meetingroom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeetingRoomDto {
    LocalDate bookingDate;
    Boolean isAvailable;
}
