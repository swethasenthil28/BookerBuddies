package org.bookerbuddies.bookease.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.owner.Owner;

@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;
    private String name;
    private Double balance;
    private String role;



    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Account(Integer accountId, String name, Double balance, String role) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
        this.role = role;

    }

    public Account(String name, Double balance, String role) {
        this.name = name;
        this.balance = balance;
        this.role = role;
    }

    public Account() {
    }
}
