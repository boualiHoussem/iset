package com.iset.banking.dao.entities;

import com.iset.banking.common.Address;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
@Data
@Entity
public class Bank {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "bank")
    List<BankCustomer> customers;

}
