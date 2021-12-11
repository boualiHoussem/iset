package com.iset.banking.service.impl;

import com.iset.banking.dao.BankDao;
import com.iset.banking.dao.entities.Bank;
import com.iset.banking.service.BankService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 11/12/2021
 */
@Service
public class BankServiceImpl implements BankService {

    private final BankDao bankDao;

    public BankServiceImpl(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @Override
    public void add(Bank bank) {
        bankDao.saveOrUpdate(bank);
    }

    @Override
    public void update(Bank bank) {
        if (bank != null) {
            Integer id = bank.getId();
            Bank bankById = bankDao.getBankById(id);
            if (bankById != null) {
                bankDao.saveOrUpdate(bank);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        bankDao.deleteBank(id);
    }

    @Override
    public Bank findById(Integer id) {
        return bankDao.getBankById(id);
    }

    @Override
    public List<Bank> findAll() {
        return bankDao.getAllBanks();
    }
}
