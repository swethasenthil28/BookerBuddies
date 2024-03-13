package org.bookerbuddies.bookease.meetingroom;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.bookerbuddies.bookease.booking.Booking;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Getter
@Setter
public class MeetingRoom {
    @Id
   //@GeneratedValue
    private Integer id;
    @NotBlank(message = "Name cant be null, it should contain chars")
    @Pattern(regexp = "[a-zA-Z ]{3,16}", message = "Name should contain min 3 & max 16 chars , no digits and special chars allowed.")
    private String name;
    private Integer capacity;
    private Integer floorNumber;
    private String type;
    private LocalDate date;
    @Min(value = 1000, message = "Min amount is 1000Rs")
    private Double costOfRoom;
    private Boolean isAvailable;
    @OneToOne
    private Booking booking;

    public MeetingRoom(Integer id, String name, Integer capacity, Integer floorNumber, String type, LocalDate date, Double costOfRoom, Boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.floorNumber = floorNumber;
        this.type = type;
        this.date = date;
        this.costOfRoom = costOfRoom;
        this.isAvailable = isAvailable;
    }
}