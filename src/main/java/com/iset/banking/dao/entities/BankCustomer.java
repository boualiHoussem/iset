package com.iset.banking.dao.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
//@Table(name = "Client")
public class BankCustomer /* PascalCase ==> Bank_Customer */ {

    /*
    String ==> varchar(255)
    Integer ==> Number
    Boolean ==> Number(1)
     */

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName; // camelCase ==> first_name
    private String lastName; // last_name
    private Integer cin;
    @Embedded
    private Address address;
    private String username;
    private String password;
    @ManyToOne
//    @JoinColumn(name = "FK_ID_BANK", referencedColumnName = "id")
    private Bank bank;

    @OneToMany(mappedBy = "bankCustomer")
    private List<Account> account;
}
