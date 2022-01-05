package com.banking.bankingapi.controller;

import com.banking.bankingapi.model.Account;
import com.banking.bankingapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/accounts")
public class AccountsController {

    private AccountService accountService;
    private static final Logger LOGGER = Logger.getLogger(AccountsController.class.getName());


    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

//    ************************ ACCOUNTS MAPPING **************************

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        LOGGER.info("Getting All Accounts...");
        return accountService.getAccounts();
    }

    @GetMapping("/hello")
    public String whatsGood() {
        return "What's Good?";
    }

    @GetMapping(path = "/accounts/{accountId}")
    public Account getAccount(@PathVariable Long accountId) {
        LOGGER.info("Getting Account" + accountId + "...");
        return accountService.getAccount(accountId);
    }

    @PostMapping(path = "/accounts")
    public Account createAccount(@RequestBody Account accountObject) {
        LOGGER.info("Creating Account...");
        return accountService.createAccount(accountObject);
    }

    @PutMapping(path = "/accounts/{accountId}")
    public Account updateAccount(@PathVariable(value = "accountId") Long accountId, @RequestBody Account accountObject) {
        LOGGER.info("Updating Account...");
        return accountService.updateAccount(accountId, accountObject);
    }

    @DeleteMapping("/accounts/{accountId}")
    public String deleteAccount(@PathVariable(value = "accountId") Long accountId) {
        LOGGER.info("Deleting Account...");
        return accountService.deleteAccount(accountId);
    }

}
