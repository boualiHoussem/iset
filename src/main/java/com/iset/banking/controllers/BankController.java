package com.iset.banking.controllers;

import com.iset.banking.dao.entities.Bank;
import com.iset.banking.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
@RestController
@RequestMapping("/banks")
@CrossOrigin(origins = {"http://localhost:4200"})
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/add")
    public void add(@RequestBody Bank bank) {
        bankService.add(bank);
    }

    @PutMapping("/update")
    public void update(@RequestBody Bank bank) {
        bankService.update(bank);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        bankService.delete(id);
    }

    @GetMapping("/getById")
    public Bank getById(@RequestParam Integer id) {
        return bankService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Bank> getAll() {
        return bankService.findAll();
    }
}
