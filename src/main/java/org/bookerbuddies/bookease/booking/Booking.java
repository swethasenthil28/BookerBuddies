package org.bookerbuddies.bookease.booking;

import jakarta.persistence.*;
import lombok.*;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.feedback.FeedBack;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.payment.Payment;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Integer id;
    private LocalDate bookingDate;
    private LocalDate bookedDate;
    private Boolean status;
    private String eventDescription;

    @OneToOne
    private Payment payment;

    @OneToOne
    private FeedBack feedBack;


}
