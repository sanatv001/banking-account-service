package com.sv.account_service.service;

import com.sv.account_service.models.Account;
public interface AccountService{
    Account createAccount(Account account);
    String debit(Long accountId, Double amount);
    String credit(Long accountId, Double amount);
    Double getBalance(Long accountId);
}
