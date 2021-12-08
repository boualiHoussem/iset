package com.iset.banking.dao.entities;

import com.iset.banking.common.enums.AccountState;
import com.iset.banking.common.enums.AccountType;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Integer id;
    private Long accountNumber;
    private Double accountBalance;
    @Enumerated(EnumType.STRING)
    private AccountState status;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne
    private BankCustomer bankCustomer;


}
