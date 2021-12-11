package com.iset.banking.controllers;

import com.iset.banking.dao.entities.Account;
import com.iset.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public void add(@RequestBody Account account) {
        accountService.add(account);
    }

    @PutMapping("/update")
    public void update(@RequestBody Account account) {
        accountService.update(account);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        accountService.delete(id);
    }

    @GetMapping("/getById")
    public Account getById(@RequestParam Integer id) {
        return accountService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Account> getAll() {
        return accountService.findAll();
    }
}
