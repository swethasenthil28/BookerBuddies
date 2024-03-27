package org.bookerbuddies.bookease.client;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.booking.Booking;
import org.bookerbuddies.bookease.payment.Payment;

import java.util.ArrayList;
import java.util.List;
//@NoArgsConstructor
@Data
//@Builder
//@AllArgsConstructor

@Entity
public class Client {
    @Id
    private Integer clientId;
    //    @NotBlank(message = "Name cannot be null")
//    @Pattern(regexp="[a-zA-Z]{2,10}",message="Your name should be min 2& max 10")
    private String name;
    //    @Email(message="Email should contain @")
    private String email;
    private String password;
    @OneToOne
    private Account account;

    @OneToMany(fetch = FetchType.EAGER)
    List<Booking> bookings = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    List<Payment> payment = new ArrayList<>();


    public Client(Integer clientId, String email, String password, String name, Account account) {
        this.clientId = clientId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.account = account;
    }
    public Client(Integer clientId, String email, String password, String name) {
        this.clientId = clientId;
        this.email = email;
        this.password = password;
        this.name = name;

    }

    public Client(String name, Integer clientId, String email, String password, Account account, List<Booking> bookings, List<Payment> payment) {
        this.name = name;
        this.clientId = clientId;
        this.email = email;
        this.password = password;
        this.account = account;
        this.bookings = bookings;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return clientId;
    }

    public void setId(Integer id) {
        this.clientId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }

    public Client() {
    }
}
