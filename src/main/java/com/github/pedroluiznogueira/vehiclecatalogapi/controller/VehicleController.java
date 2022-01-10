package com.github.pedroluiznogueira.vehiclecatalogapi.controller;

import com.github.pedroluiznogueira.vehiclecatalogapi.model.User;
import com.github.pedroluiznogueira.vehiclecatalogapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> create(@PathVariable ("id") Integer id) {
        User user = userRepository.findById(id).get();
        if (user.getIsAdmin() == false) return new ResponseEntity("only admin users can access this end-point", HttpStatus.BAD_REQUEST);

        return new ResponseEntity(user, HttpStatus.OK);
    }

}
