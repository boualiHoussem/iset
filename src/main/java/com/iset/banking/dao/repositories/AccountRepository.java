package com.iset.banking.dao.repositories;

import com.iset.banking.dao.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
