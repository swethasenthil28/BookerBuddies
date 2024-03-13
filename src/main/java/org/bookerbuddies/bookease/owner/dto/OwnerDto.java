package org.bookerbuddies.bookease.owner.dto;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.bookerbuddies.bookease.account.Account;

public class OwnerDto {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String password;


    @OneToOne
    private Account account;

    public OwnerDto(Integer id, String name, String email, String password,Account account) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.account=account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "OwnerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", account=" + account +
                '}';
    }
}
