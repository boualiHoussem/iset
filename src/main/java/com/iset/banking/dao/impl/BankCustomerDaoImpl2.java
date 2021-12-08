package com.iset.banking.dao.impl;

import com.iset.banking.dao.BankCustomerDao;
import com.iset.banking.dao.entities.BankCustomer;
import com.iset.banking.dao.repositories.BankCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
@Repository
public class BankCustomerDaoImpl2 implements BankCustomerDao {

    @Autowired
    private BankCustomerRepository bankCustomerRepository;

    @Override
    public void addBankCustomer(BankCustomer bankCustomer) {
        // Insert into BankCustomer (...) values (...)
        bankCustomerRepository.save(bankCustomer);
    }

    @Override
    public void updateBankCustomer(BankCustomer bankCustomer) {
        // Update BankCustomer set ... Where id = ...
        bankCustomerRepository.save(bankCustomer);
    }

    @Override
    public void deleteBankCustomer(Integer id) {
        // Delete from BankCustomer Where id = ...
        bankCustomerRepository.deleteById(id);
    }

    @Override
    public BankCustomer getBankCustomerById(Integer id) {
        // Select * from BankCustomer Where id = ....
        return bankCustomerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<BankCustomer> getAllCustomers() {
        // Select * from BankCustomer
        return bankCustomerRepository.findAll();
    }
}
