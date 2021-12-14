package com.iset.banking.controllers;

import com.iset.banking.common.JwtUtils;
import com.iset.banking.common.dto.LoginModel;
import com.iset.banking.common.dto.LoginResponse;
import com.iset.banking.dao.entities.BankCustomer;
import com.iset.banking.service.BankCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Houssem BOUALI
 * date: 14/12/2021
 */
@RestController
@RequestMapping("/access/")
public class AccessController {


    private final AuthenticationManager authManager;
    private final JwtUtils tokenUtils;
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final BankCustomerService bankCustomerService;


    @Autowired
    public AccessController(AuthenticationManager authManager,
                            JwtUtils tokenUtils,
                            @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService,
                            BCryptPasswordEncoder passwordEncoder, BankCustomerService bankCustomerService) {
        this.authManager = authManager;
        this.tokenUtils = tokenUtils;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.bankCustomerService = bankCustomerService;
    }

    @PostMapping("/authenticate")
    public LoginResponse authenticate(@RequestBody LoginModel login) {
        authenticate(login.getUsername(), login.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUsername());
        final String token = tokenUtils.generateToken(userDetails);
        return new LoginResponse(token);
    }

    @PostMapping("/register")
    public void register(@RequestBody BankCustomer bankCustomer) {
        String encode = passwordEncoder.encode(bankCustomer.getPassword());
        bankCustomer.setPassword(encode);
        bankCustomerService.add(bankCustomer);
    }

    private void authenticate(String username, String password) throws AuthenticationException {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException de) {
            throw new DisabledException("USER DISABLED", de);
        } catch (BadCredentialsException bce) {
            throw new BadCredentialsException("Invalid credentials", bce);
        }
    }
}
