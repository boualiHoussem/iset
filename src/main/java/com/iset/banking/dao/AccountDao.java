package com.iset.banking.dao;

import com.iset.banking.dao.entities.Account;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
public interface AccountDao {

    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);

    Account getAccountById(Integer id);

    List<Account> getAllAccounts();
}
