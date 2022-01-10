package com.github.pedroluiznogueira.vehiclecatalogapi.service;

import com.github.pedroluiznogueira.vehiclecatalogapi.dto.UserDto;
import com.github.pedroluiznogueira.vehiclecatalogapi.model.User;
import com.github.pedroluiznogueira.vehiclecatalogapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserModelService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public UserDto register(User user) throws InterruptedException {
        if (user.getPassword().isEmpty()) return null;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Thread.sleep(3000);
        userRepository.save(user);

        return new UserDto(user.getEmail(), user.getPassword());
    }

    public String auth(UserDto user) throws InterruptedException {
        UsernamePasswordAuthenticationToken loginCredentials = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
        Authentication authentication = authenticationManager.authenticate(loginCredentials);
        Thread.sleep(3000);
        if (!authentication.isAuthenticated()) return null;
        return tokenService.generateToken(authentication);
    }

    public User findUserByName(String name) {
        User user = userRepository.findUserByName(name);
        if (user == null) return null;

        return user;
    }

    public User findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) return null;

        return user;
    }
}