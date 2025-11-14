package com.example.Entity;

import jakarta.persistence.*;

@Entity
@Table
public class Account {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_number;
   @Column
   private String account_holder_name ;
   @Column
   private Double account_balanace ;

    public Account() {
    }

    public Account(String account_holder_name, Double account_balanace) {
        this.account_holder_name = account_holder_name;
        this.account_balanace = account_balanace;
    }

    public Long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Long account_number) {
        this.account_number = account_number;
    }

    public String getAccount_holder_name() {
        return account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public Double getAccount_balanace() {
        return account_balanace;
    }

    public void setAccount_balanace(Double account_balanace) {
        this.account_balanace = account_balanace;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_number=" + account_number +
                ", account_holder_name='" + account_holder_name + '\'' +
                ", account_balanace=" + account_balanace +
                '}';
    }

}
