package com.iset.banking.service.impl;

import com.iset.banking.dao.BankCustomerDao;
import com.iset.banking.dao.entities.BankCustomer;
import com.iset.banking.service.BankCustomerService;
import com.iset.banking.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
@Service
public class BankCustomerServiceImpl implements BankCustomerService {

    @Autowired
    @Qualifier("BankCustomerDaoBean")
    private BankCustomerDao bankCustomerDao;

    @Autowired
    private BankService bankService;

    @Override
    public void add(BankCustomer bankCustomer) {
        bankCustomerDao.addBankCustomer(bankCustomer);
    }

    @Override
    public void update(BankCustomer bankCustomer) {
        bankCustomerDao.updateBankCustomer(bankCustomer);
    }

    @Override
    public void delete(Integer id) {
        bankCustomerDao.deleteBankCustomer(id);
    }

    @Override
    public BankCustomer findById(Integer id) {
        return bankCustomerDao.getBankCustomerById(id);
    }

    @Override
    public List<BankCustomer> findAll() {
        return bankCustomerDao.getAllCustomers();
    }
}
