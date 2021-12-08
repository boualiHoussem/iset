package com.iset.banking.service;

import com.iset.banking.dao.entities.BankCustomer;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
public interface BankCustomerService {

    void add(BankCustomer bankCustomer);

    void update(BankCustomer bankCustomer);

    void delete(Integer id);

    BankCustomer findById(Integer id);

    List<BankCustomer> findAll();
}
