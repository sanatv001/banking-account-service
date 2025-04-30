package com.sv.account_service.serviceImpl;

import com.sv.account_service.models.Account;
import com.sv.account_service.repository.AccountRepository;
import com.sv.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public String debit(Long accountId, Double amount) {
        Optional<Account> optional=accountRepository.findById(accountId);
        if (optional.isPresent()){
            Account acc=optional.get();
            acc.setBalance(acc.getBalance()-amount);
            accountRepository.save(acc);
            return "Debited "+ amount+" from account "+ accountId;
        }
        return "Account Not Found";
    }

    @Override
    public String credit(Long accountId, Double amount) {
        Optional<Account>optional=accountRepository.findById(accountId);
        if (optional.isPresent()){
            Account acc=optional.get();
            acc.setBalance(acc.getBalance()+amount);
            accountRepository.save(acc);
            return "Credited "+ amount+" to account "+accountId;
        }
        return "Account Not Found";
    }

    @Override
    public Double getBalance(Long accountId) {
        return accountRepository.findById(accountId).map(Account::getBalance).orElse(null);
    }
}
