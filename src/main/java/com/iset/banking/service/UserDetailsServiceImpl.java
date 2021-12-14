package com.iset.banking.service;

import com.iset.banking.dao.entities.BankCustomer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author Houssem BOUALI
 * date: 14/12/2021
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private BankCustomerService bankCustomerService;

    public UserDetailsServiceImpl(BankCustomerService bankCustomerService) {
        this.bankCustomerService = bankCustomerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BankCustomer bankCustomer = bankCustomerService.findByUsername(username);


       /*  Without JAVA 8
       ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : bankCustomer.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(
                bankCustomer.getUsername(),
                bankCustomer.getPassword(),
                authorities
        );

        */

        // With Java8
        return new User(
                bankCustomer.getUsername(),
                bankCustomer.getPassword(),
                bankCustomer.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList())
        );
    }
}
