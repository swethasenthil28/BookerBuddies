package org.bookerbuddies.bookease.owner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.booking.Booking;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.feedback.FeedBack;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.payment.Payment;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Owner {
    @Getter
    @Setter
//    @NotBlank(message = "Name cannot be null")
//    @Pattern(regexp = "[a-zA-Z ]{3,15}", message = "Name should contain min 3 & max 15 chars , no digits and special chars allowed.")
    private String name;
//    @NotBlank(message = "Id cannot be null")
    @Id
    private Integer id;
//    @NotBlank(message = "Email cannot be null")
//    @Email
    private String email;
//    @NotEmpty
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,20}$", message = "Password must be 6-20 characters with at least one letter and one digit")
    private String password;

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @OneToOne
    private Account account;

    @OneToMany
    List<MeetingRoom> meetingRooms = new ArrayList<>();
    @OneToMany
    List<Client> clients = new ArrayList<>();
    @OneToMany
    List<Booking> bookings = new ArrayList<>();

    @OneToMany
    List<Payment> viewPayments=new ArrayList<>();


//    public Owner(String name, Integer id, String email, String password, Account account) {
//        this.name = name;
//        this.id = id;
//        this.email = email;
//        this.password = password;
//        this.account = account;
//    }
//
//    public Owner() {
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public List<MeetingRoom> getMeetingRooms() {
//        return meetingRooms;
//    }
//
//    public void setMeetingRooms(List<MeetingRoom> meetingRooms) {
//        this.meetingRooms = meetingRooms;
//    }
//
//    public List<Client> getClients() {
//        return clients;
//    }
//
//    public void setClients(List<Client> clients) {
//        this.clients = clients;
//    }
//
//    public List<Booking> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(List<Booking> bookings) {
//        this.bookings = bookings;
//    }

//    public List<Payment> getViewPayments() {
//        return viewPayments;
//    }
//
//    public void setViewPayments(List<Payment> viewPayments) {
//        this.viewPayments = viewPayments;
//    }
}
