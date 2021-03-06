package com.banking.bankingapi.controller;

import com.banking.bankingapi.model.Account;
import com.banking.bankingapi.model.Transaction;
import com.banking.bankingapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api")
public class AccountsController {

    private AccountService accountService;
    private static final Logger LOGGER = Logger.getLogger(AccountsController.class.getName());


    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

//    ************************ ACCOUNTS MAPPING -- DONE **************************
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

    /**
     * Delete single account
     * @param accountId
     * @return
     */
    @DeleteMapping("/accounts/{accountId}")
    public String deleteAccount(@PathVariable(value = "accountId") Long accountId) {
        LOGGER.info("Deleting Account...");
        return accountService.deleteAccount(accountId);
    }

//    ************************ Transaction MAPPING -- DONE **************************

    /**
     * Create single transaction for this current account
     * @param accountId
     * @param transactionObject
     * @return
     */
    @PostMapping("/accounts/{accountId}/transaction")
    public Transaction createAccountTransaction(@PathVariable Long accountId, @RequestBody Transaction transactionObject ) {
        LOGGER.info("Creating Account Transaction...");
        return accountService.createAccountTransaction(accountId,transactionObject);
    }

    /**
     * Get all transactions of the current account
     * @param accountId
     * @return
     */
    @GetMapping("/accounts/{accountId}/transaction")
    public List<Transaction> getAccountTransactions(@PathVariable Long accountId ) {
        LOGGER.info("Account Transactions...");
        return accountService.getAccountTransactions(accountId);
    }

    /**
     * Get
     * @param accountId
     * @param transactionId
     * @return
     */
    @GetMapping("/accounts/{accountId}/transaction/{transactionId}")
    public Transaction getAccountTransaction(@PathVariable Long accountId, @PathVariable Long transactionId) {
        LOGGER.info("Single Account Transaction...");
        return accountService.getAccountTransaction(accountId, transactionId);
    }

    @PutMapping("/accounts/{accountId}/transaction/{transactionId}")
    public Transaction updateAccountTransaction(@PathVariable Long accountId, @PathVariable Long transactionId, @RequestBody Transaction transactionObject) {
        LOGGER.info("Updating Account Transaction...");
        return accountService.updateAccountTransaction(accountId, transactionId,transactionObject);
    }
}
