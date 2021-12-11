package com.iset.banking.dao.impl;

import com.iset.banking.dao.BankDao;
import com.iset.banking.dao.entities.Bank;
import com.iset.banking.dao.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
@Repository
public class BankDaoImpl implements BankDao {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public void saveOrUpdate(Bank bank) {
        bankRepository.save(bank);
    }

    @Override
    public void deleteBank(Integer id) {
        bankRepository.deleteById(id);
    }

    @Override
    public Bank getBankById(Integer id) {
        return bankRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }
}
