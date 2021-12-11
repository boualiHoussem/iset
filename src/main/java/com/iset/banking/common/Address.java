package com.iset.banking.common;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * @author Houssem BOUALI
 * date: 08/12/2021
 */
@Data
@Embeddable
public class Address {

    private String street;
    private String city;
    private Integer zipCode;
    private String country;
    private Integer countryCode;
}
