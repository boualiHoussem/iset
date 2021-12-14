package com.iset.banking.common.dto;

import lombok.Data;

/**
 * @author Houssem BOUALI
 * date: 14/12/2021
 */
@Data
public class LoginResponse {

    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }
}
