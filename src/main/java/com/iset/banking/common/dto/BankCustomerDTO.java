package com.iset.banking.common.dto;

import com.iset.banking.common.Address;
import com.iset.banking.dao.entities.BankCustomer;
import lombok.Data;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */

// Data Transfer Object
@Data
public class BankCustomerDTO {

    private Integer id;
    private String firstName; // camelCase ==> first_name
    private String lastName; // last_name
    private Integer cin;
    private Address address;
    private String username;
    private String password;
    private Integer bankId;



    // MAPPING ENTITY <-> DTO
    public static BankCustomer fromDTO(BankCustomerDTO dto) {
        BankCustomer bankCustomer = new BankCustomer();
        bankCustomer.setId(dto.getId());

        return bankCustomer;
    }

    public static BankCustomerDTO fromEntity(BankCustomer entity) {
        BankCustomerDTO dto = new BankCustomerDTO();
        dto.setId(entity.getId());
        dto.setBankId(entity.getBank().getId());
        return dto;
    }
}
