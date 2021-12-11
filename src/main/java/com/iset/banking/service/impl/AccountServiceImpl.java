package com.iset.banking.service.impl;

import com.iset.banking.dao.AccountDao;
import com.iset.banking.dao.entities.Account;
import com.iset.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 11/12/2021
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void add(Account account) {
        accountDao.saveOrUpdate(account);
    }

    @Override
    public void update(Account account) {
        if (account != null) {
            Integer id = account.getId();
            if (id != null) {
                Account accountById = accountDao.getAccountById(id);
                if (accountById != null) {
                    accountDao.saveOrUpdate(account);
                }
            }
        }
    }

    @Override
    public void delete(Integer id) {
        accountDao.deleteAccount(id);
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.getAccountById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.getAllAccounts();
    }
}
