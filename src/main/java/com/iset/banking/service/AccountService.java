package com.iset.banking.service;

import com.iset.banking.dao.entities.Account;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
public interface AccountService {

    void add(Account account);

    void update(Account account);

    void delete(Integer id);

    Account findById(Integer id);

    List<Account> findAll();
}
