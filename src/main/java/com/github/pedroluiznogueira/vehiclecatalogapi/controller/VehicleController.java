package com.github.pedroluiznogueira.vehiclecatalogapi.controller;

import com.github.pedroluiznogueira.vehiclecatalogapi.model.User;
import com.github.pedroluiznogueira.vehiclecatalogapi.model.Vehicle;
import com.github.pedroluiznogueira.vehiclecatalogapi.repository.UserRepository;
import com.github.pedroluiznogueira.vehiclecatalogapi.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VehicleController {

    private final UserRepository userRepository;
    private final VehicleService vehicleService;

    @PostMapping("/register/{userId}")
    public ResponseEntity<Vehicle> register(@PathVariable ("userId") Integer userId, @RequestBody Vehicle vehicle) {

        User user = userRepository.findById(userId).get();
        if (user.getIsAdmin() == false) return new ResponseEntity("only admin users can access this end-point", HttpStatus.BAD_REQUEST);

        Vehicle resp = vehicleService.register(vehicle);
        if (resp == null) return new ResponseEntity("something went wrong", HttpStatus.BAD_REQUEST);

        return new ResponseEntity(resp, HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Vehicle>> findAll() {

        List<Vehicle> resp = vehicleService.findAll();
        if (resp.isEmpty()) return new ResponseEntity("there's no vehicle in the catalog", HttpStatus.BAD_REQUEST);

        return new ResponseEntity(resp, HttpStatus.OK);
    }

    @PutMapping("/update/{id}/user/{userId}")
    public ResponseEntity<Vehicle> update(@PathVariable ("id") Integer id, @PathVariable ("userId") Integer userId, @RequestBody Vehicle vehicle) {

        User user = userRepository.findById(userId).get();
        if (user.getIsAdmin() == false) return new ResponseEntity("only admin users can access this end-point", HttpStatus.BAD_REQUEST);

        Vehicle resp = vehicleService.update(id, vehicle);
        if (resp == null) return new ResponseEntity("there's no vehicle with the given id", HttpStatus.BAD_REQUEST);

        return new ResponseEntity(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}/user/{userId}")
    public ResponseEntity<String> delete(@PathVariable ("id") Integer id, @PathVariable ("userId") Integer userId) {

        User user = userRepository.findById(userId).get();
        if (user.getIsAdmin() == false) return new ResponseEntity("only admin users can access this end-point", HttpStatus.BAD_REQUEST);

        String resp = vehicleService.delete(id);
        if (resp == null) return new ResponseEntity("there's no vehicle in the catalog", HttpStatus.BAD_REQUEST);

        return new ResponseEntity(resp, HttpStatus.OK);
    }

}
