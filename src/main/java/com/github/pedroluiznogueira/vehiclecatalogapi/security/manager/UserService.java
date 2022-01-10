package com.github.pedroluiznogueira.vehiclecatalogapi.security.manager;

import com.github.pedroluiznogueira.vehiclecatalogapi.security.provider.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AuthProvider userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public boolean login(User user) {
        // we need a UserDetails object to create a token
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), userDetails.getAuthorities());

        // manager component verifies user's token
        authenticationManager.authenticate(token);

        // token is stored in security context if authenticated
        boolean result = token.isAuthenticated();
        if (result) SecurityContextHolder.getContext().setAuthentication(token);

        return result;
    }
}