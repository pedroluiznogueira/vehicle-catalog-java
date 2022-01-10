package com.github.pedroluiznogueira.vehiclecatalogapi.controller;

import com.github.pedroluiznogueira.vehiclecatalogapi.dto.TokenDto;
import com.github.pedroluiznogueira.vehiclecatalogapi.dto.UserDto;
import com.github.pedroluiznogueira.vehiclecatalogapi.model.User;
import com.github.pedroluiznogueira.vehiclecatalogapi.service.UserModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final UserModelService userModelService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody User user) throws InterruptedException {
        UserDto userDto = userModelService.register(user);
        if (userDto == null) return new ResponseEntity("password can't be null", HttpStatus.BAD_REQUEST);

        return new ResponseEntity(userDto, HttpStatus.CREATED);
    }

    @PostMapping("/auth")
    public ResponseEntity<TokenDto> auth(@RequestBody UserDto user) throws InterruptedException {
        String token = userModelService.auth(user);
        if (token == null) return new ResponseEntity("invalid email or password", HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(TokenDto.builder().type("Bearer").token(token).build());
    }

    @GetMapping("/find/by/name/{name}")
    public ResponseEntity<User> findUserByName(@PathVariable ("name") String name) {
        User user = userModelService.findUserByName(name);
        if (user == null) return new ResponseEntity("there's no user with the given name", HttpStatus.BAD_REQUEST);

        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping("/find/by/email/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable ("email") String email) {
        User user = userModelService.findUserByEmail(email);
        if (user == null) return new ResponseEntity("there's no user with the given email", HttpStatus.BAD_REQUEST);

        return new ResponseEntity(user, HttpStatus.OK);
    }
}
