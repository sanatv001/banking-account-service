package com.sv.account_service.controllers;

import com.sv.account_service.models.Account;
import com.sv.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return ResponseEntity.ok(accountService.createAccount(account));
    }
    @PostMapping("/debit")
    public ResponseEntity<String> debit(@RequestParam Long accountId,@RequestParam Double ammount){
        return ResponseEntity.ok(accountService.debit(accountId,ammount));
    }

    @PostMapping("/credit")
    public ResponseEntity<String> credit(@RequestParam Long accountId,@RequestParam Double ammount){
       return ResponseEntity.ok(accountService.credit(accountId,ammount));
    }
    @GetMapping("/balance")
    public ResponseEntity<Double> checkBalance(@RequestParam Long accountId){
        return ResponseEntity.ok(accountService.getBalance(accountId));
    }
}
