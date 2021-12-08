package com.iset.banking.controllers;

import com.iset.banking.dao.entities.BankCustomer;
import com.iset.banking.service.BankCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
@RestController
@RequestMapping("/customers")
public class BankCustomerController {

    @Autowired
    private BankCustomerService bankCustomerService;

    @PostMapping("/add")
    public void add(@RequestBody BankCustomer bankCustomer) {
        bankCustomerService.add(bankCustomer);
    }

    @PutMapping("/update")
    public void update(@RequestBody BankCustomer bankCustomer) {
        bankCustomerService.update(bankCustomer);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        bankCustomerService.delete(id);
    }

    @GetMapping("/getById")
    public BankCustomer getById(@RequestParam Integer id) {
        return bankCustomerService.findById(id);
    }

    @GetMapping("/getAll")
    public List<BankCustomer> getAll() {
        return bankCustomerService.findAll();
    }
}
