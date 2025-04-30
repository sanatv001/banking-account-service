package com.sv.account_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
public class Account {

    @Id
    @NotNull(message = "Account ID is required")
    @Min(value = 10000000L, message = "Account ID must be at least 8 digits")
    private Long accountId;
    private String customerName;
    private Double balance;

    public Account(Long accountId, String customerName, Double balance) {
        this.accountId = accountId;
        this.customerName = customerName;
        this.balance = balance;
    }

    public Account() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
