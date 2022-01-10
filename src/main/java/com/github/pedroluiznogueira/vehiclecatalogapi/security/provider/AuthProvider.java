package com.github.pedroluiznogueira.vehiclecatalogapi.security.provider;

import com.github.pedroluiznogueira.vehiclecatalogapi.model.User;
import com.github.pedroluiznogueira.vehiclecatalogapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthProvider implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // will be used by AuthenticationProvider
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if (user == null) throw new UsernameNotFoundException("User not found for email " + username);


        return user;
    }
}