package com.iset.banking.dao;

import com.iset.banking.dao.entities.Bank;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
public interface BankDao {

    void saveOrUpdate(Bank bank);

    void deleteBank(Integer id);

    Bank getBankById(Integer id);

    List<Bank> getAllBanks();
}
